package dxc.com.pojos;

 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class user 
{
    @Id
    private int userid;
    private String username;
    private String password;
    private long userphno;
    private String useraddress;
    private double balance;
    
    public user()
    {
        
    }

 

    public int getUserid() {
        return userid;
    }

 

    public void setUserid(int userid) {
        this.userid = userid;
    }

 

    public String getUsername() {
        return username;
    }

 

    public void setUsername(String username) {
        this.username = username;
    }

 

    public String getPassword() {
        return password;
    }

 

    public void setPassword(String password) {
        this.password = password;
    }

 

    public long getUserphno() {
        return userphno;
    }

 

    public void setUserphno(long userphno) {
        this.userphno = userphno;
    }

 

    public String getUseraddress() {
        return useraddress;
    }

 

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

 

    public double getBalance() {
        return balance;
    }

 

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}