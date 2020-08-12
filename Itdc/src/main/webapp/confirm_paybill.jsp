<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="#7FFFD4">
<center>

 

        <h2>SELECT ROOMS PAGE</h2>
        
        <form action="confirm_paybill">
       
          <p>Your Phone no</p>  
           <input type="hidden" name=userphno value="${bd.getUserphno()}">
           <h3>${bd.getUserphno() }</h3>
            
            <p>Hotel Phone no</p>  
           <input type="hidden" name=HotelPhNo value="${h.getHotelPhNo()}">
           <h3>${h.getHotelPhNo()}</h3>
           
            <p>Hotel Name</p>
            <input type="hidden" name=HotelName value="${h.getHotelName() }">
            <h3>${h.getHotelName()}</h3>
           
            <p>No Of Rooms</p>
            <input type="hidden" name=wrooms value="${bd.getWrooms() }">
            <h3>${bd.getWrooms()}</h3>
           
            <p>No Of Days</p>
            <input type="hidden" name=days value="${bd.getDays() }">
            <h3>${bd.getDays()}</h3>
           
            <p>From Date</p>
            <input type="hidden" name=fdate value="${bd.getFdate() }">
            <h3>${bd.getFdate()}</h3>
           
            <p>End Date</p>
            <input type="hidden" name=edate value="${bd.getEdate() }">
            <h3>${bd.getEdate()}</h3>
            
            <c:set var="RoomCostPerDay" value="${h.getRoomCostPerDay()}"></c:set>
            <c:set var="wrooms" value="${bd.getWrooms()}"></c:set>
              <c:set var="days" value="${bd.getDays()}"></c:set>
            
            <p>Total Rent</p>
            <input type="hidden" name=trent value="${RoomCostPerDay*wrooms*days }">
            <h3>${RoomCostPerDay*wrooms*days}</h3>
           
            <h4>If you confirm rent will detect from your account</h4>
           
            <button>Confirm and pay</button>
       
        </form>

 

</body>
</html>