<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  bgcolor="#DDDDDD">
<center>

 

        <h2 style="background-color:aqua;font-size:30px;">SELECT ROOMS PAGE</h2>
        
        <form action="PayBill">
                
                    <tr>
                        <th>Registered Phone No</th>
                        <td><input type="number" name="userphno" id="userphno" required></td><br>
                    </tr>
                    <tr>
                        <th>How Many Rooms You Want?</th>
                        <td><input type="number" name="wrooms" id="wrooms" required></td><br>
                    </tr>
                    <tr>
                        <th>How Many Days You Want?</th>
                        <td><input type="number" name="days" id="days" required></td><br>
                    </tr>
                    <tr>
                        <th>From Date</th>
                        <td><input type="date" name="fdate" id="fdate" required></td><br>
                    </tr>
                    <tr>
                        <th>End Date</th>
                        <td><input type="date" name="edate" id="edate" required></td><br>
                    </tr>
                    <tr>
                        <th></th>
                        <td><button>PayBill</button></td>
                    </tr>
                </table>
            </form>
        
</center>
</body>
</html>