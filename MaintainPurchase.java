package control;

import domain.Purchase;
import da.PurchaseDA;

public class MaintainPurchase {

    private PurchaseDA purchaseDA;

    public MaintainPurchase() {
        purchaseDA = new PurchaseDA();
    }

    public Purchase selectRecord(String ID){
        return purchaseDA.getRecord(ID);
    }
    public String selectRecord1(){
        return purchaseDA.getRecord1();
    }
    
    public Purchase getName(String pur){
        return purchaseDA.getName(pur);
    }

    public void addRecord(Purchase pur) {
        purchaseDA.addRecord(pur);
    }
    
    public void getRecord(Purchase pur) {
        purchaseDA.addRecord(pur);
    }
    
    public void updateRecord(Purchase pur) {
        purchaseDA.updateRecord(pur);
    }
    
    /*public void updateRecord1(Insurance ins){
        insuranceDA.updateRecord1(ins);
    }*/
    
    public void deleteRecord(Purchase pur) {
        purchaseDA.deleteRecord(pur);
    } 
    
    /*public String[] getCustomerName(){
        return purchaseDA.getCustomerName();
    }*/
    public String[] getClaimsName() {
        return purchaseDA.getClaimsName();
    }
    public String[] getAllCustomerContact() {
        return purchaseDA.getAllCustomerContact();
    }
    public String[] getAllPurchaseID() {
        return purchaseDA.getAllPurchaseID();
    }
    public String[] getAllPurchaseDate() {
        return purchaseDA.getAllPurchaseDate();
    }
    public String[] getAllCustomerIC() {
        return purchaseDA.getAllCustomerIC();
    }
    public String[] getClaims() {
        return purchaseDA.getClaims();
    }
    /*public String[] getPID(){
        return insuranceDA.getPID();
    }*/
    
}