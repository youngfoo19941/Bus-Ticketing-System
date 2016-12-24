package domain;

import java.io.Serializable;
import java.util.Objects;





public class Payment implements Serializable{
    private String PaymentID;
    private  double amount;
    private String StaffID;
    private String PurchaseID;
    private String PaymentType;
    private int Quantity;
    
    
    
    public Payment(){
        
    }
    
    public Payment(String PaymentID,double amount, String StaffID, String PurchaseID,String PaymentType,int Quantity){
        this.PaymentID = PaymentID;
        this.amount = amount;
        this.StaffID = StaffID;
        this.PurchaseID = PurchaseID;
        this.PaymentType = PaymentType;
        this.Quantity = Quantity;
    }
    
    public String getPaymentID(){
        return PaymentID;
    }
    public void  setPaymentID(String PaymentID){
        this.PaymentID = PaymentID;
    }
    
    public double getAmount(){
        return amount;
    }
    public void  setAmount(double amount){
        this.amount = amount;
    }
    
    public String getStaffID(){
        return StaffID;
    }
    public void  setStaffID(String StaffID){
        this.StaffID = PaymentID;
    }
    
    public String getPurchaseID(){
        return PurchaseID;
    }
    public void  setPurchaseID(String PurchaseID){
        this.PurchaseID = PurchaseID;
    }
    
    public String getPaymentType(){
        return PaymentType;
    }
    public void  setPaymentType(String PaymentType){
        this.PaymentType = PaymentType;
    }
    public int getQuantity(){
        return Quantity;
    }
    public void  setQuantity(int Quantity){
        this.Quantity = Quantity;
    }
    
}