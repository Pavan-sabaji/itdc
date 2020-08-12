package dxc.com.daos;

 

import java.util.ArrayList;
import java.util.List;

 

import org.bson.Document;

 

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

 

import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;
import dxc.com.pojos.user;

 

public class CustomerDaoImpl implements ICustomerDao
{
    MongoClient mongoclient=new MongoClient("localhost",27017);
    MongoDatabase mongoDatabase=mongoclient.getDatabase("itdc");
     
    @Override
    public boolean userregister(user u) 
    {
        MongoCollection<Document> collection=mongoDatabase.getCollection("user");
        
        Document s1=new Document();
        s1.append("userid",u.getUserid());
        s1.append("username",u.getUsername());
        s1.append("password",u.getPassword());
        s1.append("userphno",u.getUserphno());
        s1.append("useraddress",u.getUseraddress());
        s1.append("balance",u.getBalance());
        collection.insertOne(s1);
        
        return true;
    }

 

    @Override
    public boolean customerlogin(user u) {
    

 

        MongoCollection<Document> collection=mongoDatabase.getCollection("user");
        
        List<Document> documents = collection.find().into(new ArrayList<>());
        
        for(Document d : documents)
        {
            int id=(int)d.get("userid");
            String pass=(String)d.get("password");
            
            if(id==u.getUserid() && pass.equals(u.getPassword()))
            {
                return true;
            }
        }
        return false;
    }

 

    @Override
    public List<Document> hotellist(hotel h) 
    {
         MongoCollection<Document> collection = mongoDatabase.getCollection("hotel");
            List<Document> list = new ArrayList<Document>();

 

            FindIterable<Document> cursor = collection.find();
            MongoCursor<Document> itr = cursor.iterator();

 

               while (itr.hasNext())
               {
                
                Document d = itr.next();
                list.add(d);
                 }
        return list;
    }

 

    @Override
    public List<Document> bookingdetailslist(bookingdetails bd) 
    {
         MongoCollection<Document> collection = mongoDatabase.getCollection("bookingdetails");
            List<Document> list = new ArrayList<Document>();

 

            FindIterable<Document> cursor = collection.find();
            MongoCursor<Document> itr = cursor.iterator();

 

               while (itr.hasNext())
               {
                
                Document d = itr.next();
                list.add(d);
                 }
        return list;
        
    }

 

    @Override
    public boolean bookhotel(bookingdetails bd) 
    {

 

        MongoCollection<Document>  usercollection=mongoDatabase.getCollection("user");
        MongoCollection<Document> hotelcollection = mongoDatabase.getCollection("hotel");
        MongoCollection<Document> collection = mongoDatabase.getCollection("bookingdetails");
        Document s1=new Document();
        s1.append("userphno", bd.getUserphno());
        s1.append("HotelPhNo",bd.getHotelPhNo());
        s1.append("HotelName",bd.getHotelName());
        s1.append("wrooms",bd.getWrooms());
        s1.append("days",bd.getDays());
        s1.append("fdate",bd.getFdate());
        s1.append("edate",bd.getEdate());
        s1.append("trent",bd.getTrent());
        s1.append("status","booked");
        collection.insertOne(s1);
        
        double balance=this.getBalance(bd.getUserphno());
        int vacant=this.getVacantRoom(bd.getHotelPhNo());
        int accrooms=this.getAccuRoom(bd.getHotelPhNo());
        
        accrooms=accrooms+bd.getWrooms();
        System.out.println(balance+" "+vacant+" "+accrooms);
        
        if(balance<bd.getTrent()||vacant<bd.getWrooms())
        {
            return false;
        }
        
        //------------------------------------------------------
        vacant=vacant-bd.getWrooms();
        //System.out.println("bdrooms"+bd.getWrooms());
        //System.out.println(vacant);
        
        Document rfno=new Document();
        rfno.append("HotelPhNo", bd.getHotelPhNo());
        
        Document hd=new Document();
        hd.append("$set", new Document("RoomsVacant",vacant));
        
        hotelcollection.updateOne(rfno, hd);
        
        hd.append("$set", new Document("RoomsOccupied",accrooms));
        hotelcollection.updateOne(rfno, hd);
        
        //---------------------------------------------------
        balance=balance-bd.getTrent();
        //System.out.println(balance);
        //System.out.println("bdbalance"+bd.getTrent());
        Document rfno1=new Document();
        rfno1.append("userphno", bd.getUserphno());
        
        Document hd1=new Document();
        hd1.append("$set", new Document("balance",balance));
        
        usercollection.updateOne(rfno1, hd1);
        
        return true;
        
    }

 

    private int getAccuRoom(long hotelPhNo) 
    {
        MongoCollection<Document> collection = mongoDatabase.getCollection("hotel");
        
         Document b=new Document();
         b.append("HotelPhNo", hotelPhNo);

 

            FindIterable<Document> cursor = collection.find(b);
            MongoCursor<Document> itr = cursor.iterator();
            int t=0;
               while (itr.hasNext())
               {
                
                Document d = itr.next();
                t=(int)d.get("RoomsOccupied");
                 }
    
        return t;    
        
    }

 

    private int getVacantRoom(long phno) 
    {
         MongoCollection<Document> collection = mongoDatabase.getCollection("hotel");
            
         Document b=new Document();
         b.append("HotelPhNo", phno);

 

            FindIterable<Document> cursor = collection.find(b);
            MongoCursor<Document> itr = cursor.iterator();
            int t=0;
               while (itr.hasNext())
               {
                
                Document d = itr.next();
                t=(int)d.get("RoomsVacant");
                 }
    
        return t;
    }

 

    private double getBalance(long phno) 
    {
         MongoCollection<Document> collection = mongoDatabase.getCollection("user");
            
         Document b=new Document();
         b.append("userphno", phno);

 

            FindIterable<Document> cursor = collection.find(b);
            MongoCursor<Document> itr = cursor.iterator();
                double t=0;
               while (itr.hasNext())
               {
                
                Document d = itr.next();
                t=(double)d.get("balance");
                 }
        return t;
    }

 

    @Override
    public boolean CancelBooking(bookingdetails bd) 
    {
        MongoCollection<Document> collection = mongoDatabase.getCollection("bookingdetails");
        Document s1=new Document();
        s1.append("userphno", bd.getUserphno());
        s1.append("HotelPhNo",bd.getHotelPhNo());
//        s1.append("HotelName",bd.getHotelName());
//        s1.append("wrooms",bd.getWrooms());
//        s1.append("days",bd.getDays());
//        s1.append("fdate",bd.getFdate());
//        s1.append("edate",bd.getEdate());
//        s1.append("trent",bd.getTrent());
        
        Document s2=new Document();
        
        s2.append("$set", new Document("status","Requested"));
        collection.updateOne(s1,s2);
        
        return true;
        
    }

 

    

 


}
