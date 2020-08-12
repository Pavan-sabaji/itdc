package dxc.com.services;

 

import java.util.List;

 

import org.bson.Document;

 

import dxc.com.daos.CustomerDaoImpl;
import dxc.com.daos.ICustomerDao;
import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;
import dxc.com.pojos.user;

 

public class CustomerServiceImpl implements ICustomerService
{
 ICustomerDao dao=new CustomerDaoImpl();
    @Override
    public boolean userregister(user u) {
        
        return dao.userregister(u);
    }
    @Override
    public boolean customerlogin(user u) {
        
        return dao.customerlogin(u);
    }
    @Override
    public List<Document> hotellist(hotel h) {
        
        return dao.hotellist(h);
    }
    @Override
    public List<Document> bookingdetailslist(bookingdetails bd) {
        
        return dao.bookingdetailslist(bd);
    }
    @Override
    public boolean bookhotel(bookingdetails bd) {
        
        return dao.bookhotel(bd);
    }
    @Override
    public boolean CancelBooking(bookingdetails bd) {
        
        return dao.CancelBooking(bd);
    }

 


}