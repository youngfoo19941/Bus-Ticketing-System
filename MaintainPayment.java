package control;

import domain.Payment;
import da.PaymentDA;

public class MaintainPayment {

    private PaymentDA paymentDA;

    public MaintainPayment() {
        paymentDA = new PaymentDA();
    }

    public Payment selectRecord(String ID){
        return paymentDA.getRecord(ID);
    }

    public String selectRecord1() {
        return paymentDA.getRecord1();
    }
    public void addRecord(Payment payment) {
        paymentDA.addRecord(payment);
    }
    
    public void getRecord(Payment payment) {
        paymentDA.addRecord(payment);
    }
    
    public void updateRecord(Payment payment) {
        paymentDA.updateRecord(payment);
    }
    
    
    public void deleteRecord(Payment payment) {
        paymentDA.deleteRecord(payment);
    } 
    
    
    
}