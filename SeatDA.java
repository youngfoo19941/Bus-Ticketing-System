package da;

import domain.Seat;
import java.sql.*;
import javax.swing.*;

public class SeatDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "SEAT";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public SeatDA(){
        createConnection();
    }
    
    public Seat getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE SeatID = ?";
        Seat seat = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                seat = new Seat(ID, rs.getBoolean("SeatNo1"),rs.getBoolean("SeatNo2"), rs.getBoolean("SeatNo3"), rs.getBoolean("SeatNo4"), rs.getBoolean("SeatNo5"), rs.getBoolean("SeatNo6"), rs.getBoolean("SeatNo7"), rs.getBoolean("SeatNo8"), rs.getBoolean("SeatNo9"), rs.getBoolean("SeatNo10"), rs.getBoolean("SeatNo11"), rs.getBoolean("SeatNo12"), rs.getBoolean("SeatNo13"), rs.getBoolean("SeatNo14"), rs.getBoolean("SeatNo15"), rs.getBoolean("SeatNo16"), rs.getBoolean("SeatNo17"), rs.getBoolean("SeatNo18"), rs.getBoolean("SeatNo19"), rs.getBoolean("SeatNo20"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }
    
    public String getID() {
        String queryStr = "SELECT Seatid FROM " + tableName;
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
    public void addRecord(Seat seat) {
            
        try {
              
                stmt = conn.prepareStatement("INSERT INTO SEAT VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
                stmt.setString(1, seat.getSeatID());
                
                stmt.setBoolean(2, true);
                stmt.setBoolean(3, true);
                stmt.setBoolean(4, true);
                stmt.setBoolean(5, true);
                stmt.setBoolean(6, true);
                stmt.setBoolean(7, true);
                stmt.setBoolean(8, true);
                stmt.setBoolean(9, true);
                stmt.setBoolean(10, true);
                stmt.setBoolean(11, true);
                stmt.setBoolean(12, true);
                stmt.setBoolean(13, true);
                stmt.setBoolean(14, true);
                stmt.setBoolean(15, true);
                stmt.setBoolean(16, true);
                stmt.setBoolean(17, true);
                stmt.setBoolean(18, true);
                stmt.setBoolean(19, true);
                stmt.setBoolean(20, true);
                stmt.setBoolean(21, true);
                
                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Seat seat){
        
        try{
                stmt = conn.prepareStatement("UPDATE SEAT SET SEATNO1 = ?, SEATNO2 = ?, SEATNO3 = ?, SEATNO4 = ?,SEATNO5 = ?, SEATNO6 = ?, SEATNO7 = ?, SEATNO8 = ?, SEATNO9 = ?, SEATNO10 = ?, SEATNO11 = ?, SEATNO12 = ?, SEATNO13 = ?, SEATNO14 = ?, SEATNO15 = ?, SEATNO16 = ?, SEATNO17 = ?, SEATNO18 = ?, SEATNO19 = ?, SEATNO20 = ? WHERE seatID = ?");
                
                
                stmt.setBoolean(1, seat.getSeatNo1());
                stmt.setBoolean(2, seat.getSeatNo2());
                stmt.setBoolean(3, seat.getSeatNo3());
                stmt.setBoolean(4, seat.getSeatNo4());
                stmt.setBoolean(5, seat.getSeatNo5());
                stmt.setBoolean(6, seat.getSeatNo6());
                stmt.setBoolean(7, seat.getSeatNo7());
                stmt.setBoolean(8, seat.getSeatNo8());
                stmt.setBoolean(9, seat.getSeatNo9());
                stmt.setBoolean(10, seat.getSeatNo10());
                stmt.setBoolean(11, seat.getSeatNo11());
                stmt.setBoolean(12, seat.getSeatNo12());
                stmt.setBoolean(13, seat.getSeatNo13());
                stmt.setBoolean(14, seat.getSeatNo14());
                stmt.setBoolean(15, seat.getSeatNo15());
                stmt.setBoolean(16, seat.getSeatNo16());
                stmt.setBoolean(17, seat.getSeatNo17());
                stmt.setBoolean(18, seat.getSeatNo18());
                stmt.setBoolean(19, seat.getSeatNo19());
                stmt.setBoolean(20, seat.getSeatNo20());
                stmt.setString(21, seat.getSeatID());
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void deleteRecord(Seat seat){ 
        try{
            
            {
                stmt = conn.prepareStatement("DELETE FROM SEAT WHERE STAFFID = ?");
                stmt.setString(1, seat.getSeatID()); 
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
   
   public String[] getAllSeatID() {
        int count=0;
        String[] Seatid={};
        try {
              
            stmt = conn.prepareStatement("SELECT SeatID FROM SEAT");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                count++;
            }
            Seatid = new String[count];
            ResultSet rs1 = stmt.executeQuery();
            int x=0;
            while(rs1.next()){
                Seatid[x] = rs1.getString(1);
                x++;
            }  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return Seatid;
    }
   
   
}
