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
  <h2 style="background-color:aqua;font-size:30px;">HOTELS LIST</h2>
  <table border="1">
      <thead>
         <tr>
             <th>HotelId</th>
             <th>HotelName</th>
             <th>HotelPhNo</th>
             <th>HotelAddress</th>
             <th>RoomCostPerDay</th>
             <th>TotalNoOfRooms</th>
             <th>RoomsOccupied</th>
             <th>RoomsVacant</th>
             <th>Book_Hotel Option</th>
         </tr>
      </thead>  
      
   <tbody>
            <c:forEach var="h" items="${list}">
                    <form action="Book_Hotel">    
                            <tr>
                                <td>
                                    <h5><input type="hidden" name="HotelId" value="${h.HotelId}">${h.HotelId}</h5>
                                </td>
                                <td>
                                    <h5><input type="hidden" name="HotelName" value="${h.HotelName}">${h.HotelName}</h5>
                                </td>
                                <td>
                                    <h5><input type="hidden" name="HotelPhNo" value="${h.HotelPhNo}">${h.HotelPhNo}</h5>
                                </td>
                                <td>
                                    <h5><input type="hidden" name="HotelAddress" value="${h.HotelAddress}">${h.HotelAddress}</h5>
                                </td>    
                                <td>
                                    <h5><input type="hidden" name="RoomCostPerDay" value="${h.RoomCostPerDay}">${h.RoomCostPerDay}</h5>
                                </td>    
                                <td>
                                    <h5><input type="hidden" name="TotalNoOfRooms" value="${h.TotalNoOfRooms}">${h.TotalNoOfRooms}<h5>
                                </td>    
                                <td>
                                    <h5><input type="hidden" name="RoomsOccupied" value="${h.RoomsOccupied}">${h.RoomsOccupied}</h5>
                                </td>    
                                <td>
                                    <h5><input type="hidden" name="RoomsVacant" value="${h.RoomsVacant}">${h.RoomsVacant}</h5>
                                </td>
                                <td>
                                    <input type="submit" name="btn" value="Book_Hotel">
                                </td>    
                            </tr>
                            
                    </form>
                            </c:forEach>
                        </tbody>
         
</table>
    </center>     
            
</body>
</html>