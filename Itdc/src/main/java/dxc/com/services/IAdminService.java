package dxc.com.services;

 

import java.util.List;

 

import org.bson.Document;

 

import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;

 

public interface IAdminService 
{
   boolean adminlogin(int adminid, String password);

 

void AddHotel(hotel h);

 

List<Document> displayhotellist(hotel h);

 

List<Document> cancelhotelbookinglist(bookingdetails bd);

 

boolean cancelrequestedbooking(bookingdetails bd);  

 

}