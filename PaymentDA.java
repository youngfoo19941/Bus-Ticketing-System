package da;

import domain.Payment;
import java.sql.*;
import javax.swing.*;

public class PaymentDA {
    private String host = "jdbc:derby://localhost:1527/BusSystem";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PAYMENT";
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private String sqlQuery = "SELECT * FROM" + tableName;
    
    public PaymentDA(){
        createConnection();
    }
    
    public Payment getRecord(String ID) {
        String queryStr = "SELECT * FROM " + tableName + " WHERE PAYMENTID = ?";
        Payment payment = null;
        try {
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1, ID);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                payment = new Payment(ID,rs.getDouble("Amount"),rs.getString("StaffID"),rs.getString("PurchaseID"),rs.getString("PaymentType"),rs.getInt("Quantity"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }
    public String getRecord1() {
        String queryStr = "SELECT Paymentid FROM " + tableName;
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
    
        
    public void addRecord(Payment payment) {
      
        try {
              //insert a new table row refer chap 5 slides 28, change .getText to getCode refer programme.java in domain
                stmt = conn.prepareStatement("INSERT INTO PAYMENT VALUES(?, ?, ?, ?, ?,?)");
                stmt.setString(1, payment.getPaymentID());
                stmt.setDouble(2, payment.getAmount());
                stmt.setString(3, payment.getStaffID());
                stmt.setString(4, payment.getPurchaseID());
                stmt.setString(5, payment.getPaymentType());
                stmt.setInt(6, payment.getQuantity());
                

                stmt.executeUpdate();
        } 
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateRecord(Payment payment){
        
        try{
                stmt = conn.prepareStatement("UPDATE PAYMENT SET Amount = ?,StaffID = ?, PurchaseID = ?,PaymentType = ?, Quantity = ?WHERE PaymentID = ?");
                stmt.setDouble(1, payment.getAmount());
                stmt.setString(2, payment.getStaffID());
                stmt.setString(3, payment.getPurchaseID());
                stmt.setString(4, payment.getPaymentType());
                stmt.setString(5, payment.getPaymentID());
                stmt.setInt(6, payment.getQuantity());
                
                stmt.executeUpdate();
                
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void deleteRecord(Payment payment){ 
        try{
            
            {
                stmt = conn.prepareStatement("DELETE FROM PAYMENT WHERE PAYMENTID = ?");
                stmt.setString(1, payment.getPaymentID()); 
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
   
  
   
   
    
    
}