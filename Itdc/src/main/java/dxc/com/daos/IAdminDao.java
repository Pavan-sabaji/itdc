package dxc.com.daos;

 

import java.util.List;

 

import org.bson.Document;

 

import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;

 

public interface IAdminDao {

 

    boolean adminlogin(int adminid, String password);

 

    void AddHotel(hotel h);

 

    List<Document> displayhotellist(hotel h);

 

    List<Document> cancelhotelbookinglist(bookingdetails bd);

 

    boolean cancelrequestedbooking(bookingdetails bd);
 

 

}