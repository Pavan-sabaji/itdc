<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
              <style>
                    table, tr, td{
                         border: 2px solid black;
                         width : 30%;
                         text-align: center;
                    }
                </style>
</head>
<body bgcolor="#DDDDDD"> 

 

       <center>
  <h2>HOTELS LIST</h2>
  <table border="1">
      <thead>
         <tr>
             <th>Hotel id</th>
             <th>Hotel name</th>
             <th>Hotel phone number</th>
             <th>Hotel address</th>
             <th>Room cost/day</th>
             <th>Total number of Rooms</th>
             <th>Rooms booked</th>
             <th>Rooms vaccant</th>
         </tr>
      </thead>  
      
   <tbody>
            <c:forEach var="h" items="${list}">
                        
                            <tr>
                                <td>
                                    <h5><c:out value="${h.HotelId}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${h.HotelName}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${h.HotelPhNo}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${h.HotelAddress}"></c:out></h5>
                                </td>    
                                <td>
                                    <h5><c:out value="${h.RoomCostPerDay}"></c:out></h5>
                                </td>    
                                <td>
                                    <h5><c:out value="${h.TotalNoOfRooms}"></c:out></h5>
                                </td>    
                                <td>
                                    <h5><c:out value="${h.RoomsOccupied}"></c:out></h5>
                                </td>    
                                <td>
                                    <h5><c:out value="${h.RoomsVacant}"></c:out></h5>
                                </td>    
                            </tr>
                            </c:forEach>
                        </tbody>
         
</table>
    </center>     
            
</body>
</html>