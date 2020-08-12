package dxc.com;

 

import java.util.List;

 

import org.bson.Document;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

 

import dxc.com.pojos.admin;
import dxc.com.pojos.bookingdetails;
import dxc.com.pojos.hotel;
import dxc.com.services.AdminServiceImpl;
import dxc.com.services.IAdminService;

 

@Controller
public class AdminController 
{
    IAdminService adminservice=new AdminServiceImpl();
    String message="";
    
    @RequestMapping("/home")
    public String home()
    {
    	System.out.println("test");
        return "home.jsp";
    }
    
@RequestMapping("/login")
public String adminlogin(Model m, @RequestParam int adminid, @RequestParam String password )
{
    System.out.println("test22222");
    boolean b=adminservice.adminlogin(adminid,password);
    if(b==true)
    {
        return "AdminMenu.jsp";    
    }
    else
    {
        message="Incorrect Login Credentials";
        m.addAttribute("message", message);
        return "message.jsp";    
    }
    
}

 

@RequestMapping("/addhotel")
public String AddHotel(@ModelAttribute hotel h, Model m)
{
    adminservice.AddHotel(h);
    message="Hotel Added Successfully";
    m.addAttribute("message",message);
    return "message.jsp";
    
}

 

@RequestMapping("/displayhotellist")
public String displayhotellist(@ModelAttribute hotel h,Model m)
{
    List<Document> list=adminservice.displayhotellist(h);
    m.addAttribute("list", list);
    return "DisplayHotelList.jsp";
    
}
@RequestMapping("CancelHotelBookingList")
public String cancelhotelbookinglist(@ModelAttribute  bookingdetails bd,Model m)
{
    List<Document> list=adminservice.cancelhotelbookinglist(bd);
    m.addAttribute("list", list);
    return "CancelHotelBookingList.jsp";
}
@RequestMapping("/CancelRequestedBooking")
 public String cancelrequestedbooking(@ModelAttribute bookingdetails bd, Model m)
 {
    boolean b=adminservice.cancelrequestedbooking(bd);
    if(b==true)
    {
        message="Canceled Successfully";
        m.addAttribute("message",message);
        return "message.jsp";    
    }
    else
    {
        message="Cancel Booking Hotel Is Failed";
        m.addAttribute("message", message);
        return "message.jsp";    
    }
 }
}