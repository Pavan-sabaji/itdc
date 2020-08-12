package dxc.com.services;

 

import java.util.List;

 

import org.bson.Document;

 

import dxc.com.daos.AdminDaoImpl;
import dxc.com.daos.IAdminDao;
import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;

 

public class AdminServiceImpl implements IAdminService 
{
 IAdminDao dao=new AdminDaoImpl();

 

@Override
public boolean adminlogin(int adminid, String password) {
    
    return dao.adminlogin(adminid,password);
}

 

@Override
public void AddHotel(hotel h) 
{
     dao.AddHotel(h);
    
}

 

@Override
public List<Document> displayhotellist(hotel h) {
    
    return dao.displayhotellist(h);
}

 

@Override
public List<Document> cancelhotelbookinglist(bookingdetails bd) {
    
    return dao.cancelhotelbookinglist(bd);
}

 

@Override
public boolean cancelrequestedbooking(bookingdetails bd) {

 

    return dao.cancelrequestedbooking(bd);
}

 

}