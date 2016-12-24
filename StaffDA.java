package da;

import domain.Staff;
import java.sql.*;
import javax.swing.*;

public class StaffDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public StaffDA(){
        createConnection();
    }
    
    public Staff getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFFID = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(ID, rs.getString("Staffname"), rs.getString("StaffIC"), rs.getString("address"), rs.getString("password"),rs.getString("gender"),rs.getString("position"),  rs.getInt("age"), rs.getString("contactNo"),rs.getString("Email"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    public String getRecord1() {
        String queryStr = "SELECT Staffid FROM " + tableName;
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
    
    
    public Staff getName(String name) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE STAFFNAME = ?";
        Staff staff = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                staff = new Staff(rs.getString("STAFFID"), name, rs.getString("STAFFic"), rs.getString("address"), rs.getString("password"),rs.getString("gender"),rs.getString("position"),  rs.getInt("age"), rs.getString("contactNo"),rs.getString("email"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }
    
        
    public void addRecord(Staff staff) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO STAFF VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, staff.getID());
                stmt.setString(2, staff.getName());
                stmt.setString(3, staff.getAddress());
                stmt.setString(4, staff.getPassword());
                stmt.setString(5, staff.getGender());
                stmt.setString(6, staff.getPosition());
                stmt.setInt(7, staff.getAge());
                stmt.setString(8, staff.getEmail());
                stmt.setString(9, staff.getcontactNo());
                stmt.setString(10, staff.getIC());
                
                
                 
                
                
                
                
                
                
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Staff Ustaff){
        
        try{
                stmt = conn.prepareStatement("UPDATE STAFF SET staffic = ?, staffname = ?, address = ?, contactNo = ?, position = ?, gender = ?,email = ?, age = ?,  password = ? WHERE staffID = ?");
                stmt.setString(1, String.valueOf(Ustaff.getIC()));
                stmt.setString(2, Ustaff.getName());
                stmt.setString(3, Ustaff.getAddress());
                stmt.setString(4, Ustaff.getcontactNo());
                stmt.setString(5, Ustaff.getPosition());
                stmt.setString(6, Ustaff.getGender()); 
                stmt.setString(7, Ustaff.getEmail());
                stmt.setInt(8, Ustaff.getAge());
                stmt.setString(9, Ustaff.getPassword());
                stmt.setString(10, Ustaff.getID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updatepassword(Staff password){
        
        try{
                stmt = conn.prepareStatement("UPDATE STAFF SET password = ? WHERE staffID = ?");
                
                stmt.setString(1, password.getPassword());
                stmt.setString(2, password.getID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Staff staffMember){ 
        try{
            
            {
                stmt = conn.prepareStatement("DELETE FROM STAFF WHERE STAFFID = ?");
                stmt.setString(1, staffMember.getID()); 
                stmt.executeUpdate();
                  
            }
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
   
   public String[] getStaffName() {
        int count=0;
        String[] staffName={};
        try {
              
            stmt = conn.prepareStatement("SELECT STAFFNAME FROM STAFF");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            staffName = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                staffName[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffName;
    }
   public String[] getid() {
        int count=0;
        String[] staffid={};
        try {
              
            stmt = conn.prepareStatement("SELECT STAFFID FROM STAFF where Position='Driver'");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            staffid = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                staffid[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffid;
    }
   
   
   
    
    
}