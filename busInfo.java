package domain;

import java.io.Serializable;
import java.util.Objects;

public class busInfo implements Serializable{
    private String busID;
    private String busNo;
    private String staffID;
    
    public busInfo(){
        
    }
    
    public busInfo(String busID, String busNo, String staffID){
        this.busID = busID;
        this.busNo = busNo;
        this.staffID = staffID;
    }
    
    public String getbusID(){
        return busID;
    }
    public void  setbusID(String busID){
        this.busID = busID;
    }
    
    public String getbusNo(){
        return busNo;
    }
    public void  setbusNo(String busNo){
        this.busNo = busNo;
    }
    public String getStaffID(){
        return staffID;
    }
    public void setStaffID(String staffID){
        this.staffID = staffID;
    }
}