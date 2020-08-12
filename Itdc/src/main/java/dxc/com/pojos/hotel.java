package dxc.com.pojos;

 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 

@Document
public class hotel 
{
    @Id
    private int HotelId;
    private String HotelName;
    private long HotelPhNo;
    private String HotelAddress;
    private double RoomCostPerDay;
    private  int TotalNoOfRooms;
    private int RoomsOccupied;
    private int RoomsVacant;
    
    public hotel()
    {
        
    }

 

    public int getHotelId() {
        return HotelId;
    }

 

    public void setHotelId(int hotelId) {
        HotelId = hotelId;
    }

 

    public String getHotelName() {
        return HotelName;
    }

 

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

 

    public long getHotelPhNo() {
        return HotelPhNo;
    }

 

    public void setHotelPhNo(long hotelPhNo) {
        HotelPhNo = hotelPhNo;
    }

 

    public String getHotelAddress() {
        return HotelAddress;
    }

 

    public void setHotelAddress(String hotelAddress) {
        HotelAddress = hotelAddress;
    }

 

    public double getRoomCostPerDay() {
        return RoomCostPerDay;
    }

 

    public void setRoomCostPerDay(double roomCostPerDay) {
        RoomCostPerDay = roomCostPerDay;
    }

 

    public int getTotalNoOfRooms() {
        return TotalNoOfRooms;
    }

 

    public void setTotalNoOfRooms(int totalNoOfRooms) {
        TotalNoOfRooms = totalNoOfRooms;
    }

 

    public int getRoomsOccupied() {
        return RoomsOccupied;
    }

 

    public void setRoomsOccupied(int roomsOccupied) {
        RoomsOccupied = roomsOccupied;
    }

 

    public int getRoomsVacant() {
        return RoomsVacant;
    }

 

    public void setRoomsVacant(int roomsVacant) {
        RoomsVacant = roomsVacant;
    }

 

    
    

 

}