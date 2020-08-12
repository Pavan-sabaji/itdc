package dxc.com.controllers;

 

import java.util.List;

 

import javax.servlet.http.HttpSession;

 

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

 

import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;
import dxc.com.pojos.user;
import dxc.com.services.CustomerServiceImpl;
import dxc.com.services.ICustomerService;

 

@Controller
public class CustomerController 
{
    ICustomerService service=new CustomerServiceImpl();
    String message="";
 @RequestMapping("/Register")
 public String userregister(@ModelAttribute user u, Model m)
 {
     boolean b=service.userregister(u);
     if(b==true)
     {
           
            return "CustomerLogin.jsp";    

 

     }
     else
     {
            message="User Registration Failed";
            m.addAttribute("message",message);
            return "message.jsp";    

 

     }
    
 }
 
 @RequestMapping("/userlogin")
 public String customerlogin(Model m, @ModelAttribute user u )
 {
     
     boolean b=service.customerlogin(u);
     if(b==true)
     {
         return "CustomerMenu.jsp";    
     }
     else
     {
         message="Incorrect Login Credentials";
         m.addAttribute("message", message);
         return "message.jsp";    
     }

 

}
 @RequestMapping("/hotellist")
 public String displayhotellist(@ModelAttribute hotel h,Model m)
 {
     List<Document> list=service.hotellist(h);
     m.addAttribute("list", list);
     return "HotelList.jsp";
     
 }
 @RequestMapping("/Book_Hotel")
 public String Book_Hotel(@ModelAttribute hotel h, HttpSession session)
 {
     session.setAttribute("h", h);
     return "select_rooms.jsp";
 }
 
 @RequestMapping("/PayBill")
 public String PayBill(@ModelAttribute bookingdetails bd,Model m,HttpSession session)
 {
     hotel h=(hotel)session.getAttribute("h");
     //System.out.println(bd.getUserphno());
     //System.out.println(h.getRoomCostPerDay());
     m.addAttribute("bd",bd);
     m.addAttribute("h",session.getAttribute("h"));
     return "confirm_paybill.jsp";
 }
 @RequestMapping("/bookingdetails")
 public String bookingdetailslist(@ModelAttribute  bookingdetails bd,Model m)
 {
     List<Document> list=service.bookingdetailslist(bd);
     m.addAttribute("list", list);
     return "BookingHotelList.jsp";
     
 }
 @RequestMapping("/confirm_paybill")
 public String bookhotel(@ModelAttribute bookingdetails bd,Model m)
 {
     boolean b=service.bookhotel(bd);
     if(b==true)
     {
      message="Successfully Hotel Booked";
        m.addAttribute("message", message);
        return "message.jsp";
     }else
     {
         message="All Rooms are booked or Balance is Exceed ";
            m.addAttribute("message", message);
            return "message.jsp";
     }
 }
 @RequestMapping("/CancelHotelBooking")
 public String CancelBooking(@ModelAttribute bookingdetails bd,Model m)
 {
     boolean b=service.CancelBooking(bd);
     message="Successfully Hotel Booking Canceled";
     m.addAttribute("message", message);
     return "message.jsp";
     
}

 

}