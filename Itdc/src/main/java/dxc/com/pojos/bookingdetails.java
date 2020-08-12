package dxc.com.pojos;

 

public class bookingdetails 
{
    private long userphno;
    private long HotelPhNo;
    private String HotelName;
    private int wrooms;
    private int days;
    private String fdate;
    private String edate;
    private double trent;
    private String status;
    
    public bookingdetails()
    {
        
    }

 

    public long getUserphno() {
        return userphno;
    }

 

    public void setUserphno(long userphno) {
        this.userphno = userphno;
    }

 

    public long getHotelPhNo() {
        return HotelPhNo;
    }

 

    public void setHotelPhNo(long hotelPhNo) {
        HotelPhNo = hotelPhNo;
    }

 

    public String getHotelName() {
        return HotelName;
    }

 

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

 

    public int getWrooms() {
        return wrooms;
    }

 

    public void setWrooms(int wrooms) {
        this.wrooms = wrooms;
    }

 

    public int getDays() {
        return days;
    }

 

    public void setDays(int days) {
        this.days = days;
    }

 

    public String getFdate() {
        return fdate;
    }

 

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

 

    public String getEdate() {
        return edate;
    }

 

    public void setEdate(String edate) {
        this.edate = edate;
    }

 

    public double getTrent() {
        return trent;
    }

 

    public void setTrent(double trent) {
        this.trent = trent;
    }

 

    public String getStatus() {
        return status;
    }

 

    public void setStatus(String status) {
        this.status = status;
    }

 

    
    
}