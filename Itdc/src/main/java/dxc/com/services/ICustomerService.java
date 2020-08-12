package dxc.com.services;

 

import java.util.List;

 

import org.bson.Document;

 

import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;
import dxc.com.pojos.user;

 

public interface ICustomerService {

 

    boolean userregister(user u);

 

    boolean customerlogin(user u);

 

    List<Document> hotellist(hotel h);

 

    List<Document> bookingdetailslist(bookingdetails bd);

 

    boolean bookhotel(bookingdetails bd);

 

    boolean CancelBooking(bookingdetails bd);

 

    

 

}
 