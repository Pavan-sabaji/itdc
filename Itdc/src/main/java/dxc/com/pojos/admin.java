package dxc.com.pojos;

 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 

@Document
public class admin 
{
    @Id
private int adminid;
private String password;

 

public admin()
{
    
}

 

public admin(int adminid, String password) {
    super();
    this.adminid = adminid;
    this.password = password;
}

 

public int getAdminid() {
    return adminid;
}

 

public void setAdminid(int adminid) {
    this.adminid = adminid;
}

 

public String getPassword() {
    return password;
}

 

public void setPassword(String password) {
    this.password = password;
}

 

@Override
public String toString() {
    return "admin [adminid=" + adminid + ", password=" + password + "]";
}

 


}