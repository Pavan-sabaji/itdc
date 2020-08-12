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

 

public class AdminDaoImpl implements IAdminDao 
{
 MongoClient mongoclient=new MongoClient("localhost",27017);
 MongoDatabase mongoDatabase=mongoclient.getDatabase("itdc");
 
    @Override
    public boolean adminlogin(int adminid, String password) 
    {
        MongoCollection<Document> collection=mongoDatabase.getCollection("admin");
        
        List<Document> documents = collection.find().into(new ArrayList<>());
       
        for(Document d : documents)
        {
            double id=(double)d.get("adminid");
            String pass=(String)d.get("password");
            System.out.println(adminid+" "+password);
            if(id==adminid && pass.equals(password))
            {
            	System.out.println("true");
                return true;
            }
        }
        return false;
    }

 

    @Override
    public void AddHotel(hotel h) 
    {
       MongoCollection<Document> collection=mongoDatabase.getCollection("hotel");
       
       int HotelId=h.getHotelId();
       String HotelName=h.getHotelName();
       long HotelPhNo=h.getHotelPhNo();
       String HotelAddress=h.getHotelAddress();
       double RoomCostPerDay=h.getRoomCostPerDay();
       int TotalNoOfRooms=h.getTotalNoOfRooms();
       int RoomsOccupied=h.getRoomsOccupied();
       int RoomsVacant=h.getRoomsVacant();
       
       
       
           Document s1=new Document();
           s1.append("HotelId", HotelId);
           s1.append("HotelName", HotelName);
           s1.append("HotelPhNo", HotelPhNo);
           s1.append("HotelAddress", HotelAddress);
           s1.append("RoomCostPerDay", RoomCostPerDay);
           s1.append("TotalNoOfRooms", TotalNoOfRooms);
           s1.append("RoomsOccupied", RoomsOccupied);
           s1.append("RoomsVacant", TotalNoOfRooms);
           collection.insertOne(s1);
       }
        
    

 

    
    @Override
    public List<Document> displayhotellist(hotel h) {
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
    public List<Document> cancelhotelbookinglist(bookingdetails bd) {
        
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
    public boolean cancelrequestedbooking(bookingdetails bd) {
    
        MongoCollection<Document>  usercollection=mongoDatabase.getCollection("user");
        MongoCollection<Document> hotelcollection = mongoDatabase.getCollection("hotel");
        MongoCollection<Document> collection = mongoDatabase.getCollection("bookingdetails");
        Document s1=new Document();
        s1.append("userphno", bd.getUserphno());
        s1.append("HotelPhNo",bd.getHotelPhNo());
         Document s2=new Document();
        
        s2.append("$set", new Document("status","Canceled"));
        collection.updateOne(s1,s2);
        
        double balance=this.getBalance(bd.getUserphno());
        int vacant=this.getVacantRoom(bd.getHotelPhNo());
        int accrooms=this.getAccuRoom(bd.getHotelPhNo());
        System.out.println(accrooms+" "+bd.getWrooms());
        accrooms=accrooms-bd.getWrooms();
        
        System.out.println(accrooms);
        if(balance<bd.getTrent()||vacant<bd.getWrooms())
        {
            return false;
        }
        
        //------------------------------------------------------
        vacant=vacant+bd.getWrooms();
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
        balance=balance+bd.getTrent();
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
    

 

}