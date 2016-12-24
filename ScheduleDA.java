package da;

import domain.Schedule;
import java.sql.*;
import javax.swing.*;

public class ScheduleDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "SCHEDULE";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public ScheduleDA(){
        createConnection();
    }
    
    public Schedule getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE ScheduleID = ?";
        Schedule schedule = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                schedule = new Schedule(ID, rs.getString("Departure"),rs.getString("Destination"), rs.getString("BusID"), rs.getString("StaffID"),rs.getDouble("TicketPrice"),rs.getString("Date"),rs.getString("SeatID"), rs.getString("Time"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }
    
    public String getRecord1() {
        
        String queryStr = "SELECT Scheduleid FROM " + tableName;
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
    
    public Schedule getDestination(String destination) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE DESTINATION = ?";
        Schedule schedule = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, destination);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                 schedule = new Schedule(rs.getString("ScheduleID"), rs.getString("Departure"),rs.getString("Destination"), rs.getString("BusID"), rs.getString("StaffID"),rs.getDouble("TicketPrice"),rs.getString("Date"),rs.getString("SeatID"), rs.getString("Time"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return schedule;
    }
        
    public void addRecord(Schedule schedule) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO SCHEDULE VALUES(?, ?, ?, ?, ?, ?, ?,?,?)");
                stmt.setString(1, schedule.getScheduleID());
                stmt.setString(2, schedule.getDeparture());
                stmt.setString(3, schedule.getDestination());
                stmt.setString(4, schedule.getBusID());
                stmt.setString(5, schedule.getStaffID());
                stmt.setDouble(6, schedule.getTicketPrice());
                stmt.setString(7, schedule.getDate());
                stmt.setString(8, schedule.getSeatID());
                stmt.setString(9, schedule.getTime());
                

                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Schedule schedule){
        
        try{
                stmt = conn.prepareStatement("UPDATE SCHEDULE SET Departure = ?, Destination = ?, BusID = ?, StaffID = ?, Time = ?, TicketPrice = ?,Date = ?,SeatID=? WHERE ScheduleID = ?");
               
                stmt.setString(1, schedule.getDeparture());
                stmt.setString(2, schedule.getDestination());
                stmt.setString(3, schedule.getBusID());
                stmt.setString(4, schedule.getStaffID());
                stmt.setString(5, schedule.getTime());
                stmt.setDouble(6, schedule.getTicketPrice());
                stmt.setString(7, schedule.getDate());
                stmt.setString(8, schedule.getSeatID());
                stmt.setString(9, schedule.getScheduleID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteRecord(Schedule dschedule){ 
        try{
            //int yesno;
            //yesno = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "YES OR NO", JOptionPane.YES_NO_OPTION);
            //if(yesno==0)
           //{
                stmt = conn.prepareStatement("DELETE FROM SCHEDULE WHERE SCHEDULEID = ?");
                stmt.setString(1, dschedule.getScheduleID()); 
                stmt.executeUpdate();
                //JOptionPane.showMessageDialog(null, "Schedule has been deleted!");  
           // }
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
   
   public String[] getScheduleDestination() {
        int count=0;
        String[] Destination={};
        try {
              
            stmt = conn.prepareStatement("SELECT DESTINATION FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            Destination = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                Destination[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return Destination;
    }
   
   public String[] getBusSeatID() {
        int count=0;
        String[] BusID={};
        try {
              
            stmt = conn.prepareStatement("SELECT SeatID FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            BusID = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                BusID[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return BusID;
    }
   
   public String[] getscheduleID() {
        int count=0;
        String[] scheduleID={};
        try {
              
            stmt = conn.prepareStatement("SELECT ScheduleID FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            scheduleID = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                scheduleID[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return scheduleID;
    }
   
   public double[] getTicketPrice1() {
        int count=0;
        double[] scheduleID={};
        try {
              
            stmt = conn.prepareStatement("SELECT TICKETPRICE FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            scheduleID = new double[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                scheduleID[x] = rs1.getDouble(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return scheduleID;
    }
   
   public String[] getscheduleDate() {
        int count=0;
        String[] scheduleDate={};
        try {
              
            stmt = conn.prepareStatement("SELECT DATE FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            scheduleDate = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                scheduleDate[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return scheduleDate;
    }
   
   public String[] getscheduleTime() {
        int count=0;
        String[] scheduleTime={};
        try {
              
            stmt = conn.prepareStatement("SELECT TIME FROM SCHEDULE");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            scheduleTime = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                scheduleTime[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return scheduleTime;
    }
   
   
    
}