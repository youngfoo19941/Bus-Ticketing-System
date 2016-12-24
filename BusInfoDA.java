package da;

import domain.busInfo;
import java.sql.*;
import javax.swing.*;

public class BusInfoDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BUSINFORMATION";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public BusInfoDA(){
        createConnection();
    }
    
    public busInfo getRecord(String busID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BUSID = ?";
        busInfo bus = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, busID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                bus = new busInfo(busID, rs.getString("BUSNO"), rs.getString("STAFFID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bus;
    }
    
    
    public String getRecord1() {
        String queryStr = "SELECT Busid FROM " + tableName;
        String id = "";
        try {
            stmt = conn.prepareStatement(queryStr);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }
    
     public busInfo getName(String name) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE BusNo = ?";
        busInfo staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new busInfo(rs.getString("BusID"), name, rs.getString("StaffID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
        
    public void addRecord(busInfo bus) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO BUSINFORMATION VALUES(?, ?, ?)");
                stmt.setString(1, bus.getbusID());
                stmt.setString(2, bus.getbusNo());
                stmt.setString(3, bus.getStaffID());
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(busInfo uBus){
        
        try{
                stmt = conn.prepareStatement("UPDATE BUSINFORMATION SET busNo = ?, StaffID = ? WHERE BUSID = ?");
                stmt.setString(1, String.valueOf(uBus.getbusNo()));
                stmt.setString(2, String.valueOf(uBus.getStaffID()));
                stmt.setString(3, String.valueOf(uBus.getbusID()));
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(busInfo dBus){ 
        try{
            
                stmt = conn.prepareStatement("DELETE FROM BUSINFORMATION WHERE BUSID = ?");
                stmt.setString(1, dBus.getbusID()); 
                stmt.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Staff has been deleted!");  
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void createConnection(){
        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
   
   public String[] getAllBusNo() {
        int count=0;
        String[] busName={};
        try {
              
            stmt = conn.prepareStatement("SELECT BUSNO FROM BUSINFORMATION");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            busName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                busName[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busName;
    }
   
   public String[] getAllBusID() {
        int count=0;
        String[] staffID={};
        try {
              
            stmt = conn.prepareStatement("SELECT BUSID FROM BUSINFORMATION");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            staffID = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                staffID[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffID;
    }
}