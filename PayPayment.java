
package ui;
import control.MaintainPayment;
import da.PaymentDA;
import domain.Payment;
import control.MaintainPayment;
import control.*;
import da.*;
import domain.*;
import control.MaintainPayment;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
public class PayPayment extends JFrame{

    private MaintainPayment paymentMaintain = new MaintainPayment();
    private MaintainPurchase purchaseMaintain = new MaintainPurchase();
    private JLabel jlblPaymentID = new JLabel("     Payment ID:              ");
    private JTextField jtfPaymentID = new JTextField();
    private JLabel jlblAmount = new JLabel("     Total Amount:          ");
    private JTextField jtfAmount = new JTextField();
    private JLabel jlblStaffID = new JLabel("     Staff ID:                     ");
    private JTextField jtfStaffID = new JTextField();
    private JLabel jlblPurchaseID = new JLabel("     Purchase ID:            ");
    private JTextField jtfPurchaseID = new JTextField();
    private JLabel jlblQuantity = new JLabel("     Quantity:                   ");
    private JTextField jtfQuantity = new JTextField();
    private JLabel jlblPaymentType = new JLabel("     Payment Type:          ");
    private JRadioButton jrbCash = new JRadioButton("Cash");
    private JRadioButton jrbCreditCard = new JRadioButton("Credit Card");
    private JLabel jlblPay = new JLabel("     Pay:                            ");
    private JTextField jtfPay = new JTextField();
    private JButton jbtPay = new JButton("Calculate Payment");
    
    private String jtfPaymentType="";
    private JLabel jlblTicketPrice = new JLabel("     Ticket Price:            ");
    private JTextField jtfTicketPrice = new JTextField();
    
    private ButtonGroup group;
    Staff staff = new Staff();
    
    public PayPayment(int c,double a, Staff staff){
         this.staff = staff;
        String Paymentid = paymentMaintain.selectRecord1();
        String b = Paymentid.substring(1,5);
        int c2 = Integer.parseInt(b)+1;
        String payID = "P"+String.format("%d", c2);
        jtfPaymentID.setText(payID);
        jtfPaymentID.setEditable(false);
        
        String Purchaseid = purchaseMaintain.selectRecord1();
        String b1 = Paymentid.substring(1,5);
        int c1 = Integer.parseInt(b1)+1;
        String purID = "R"+String.format("%d", c1);
        jtfPurchaseID.setText(purID);
        jtfPurchaseID.setEditable(false);
        
        group = new ButtonGroup();
  	group.add(jrbCash);
  	group.add(jrbCreditCard);
        
        
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblPaymentID);
        boxes1.add(jtfPaymentID);
        
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblPurchaseID);
        boxes2.add(jtfPurchaseID);
        
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblStaffID);
        boxes3.add(jtfStaffID);
        jtfStaffID.setText(staff.getID());
        jtfStaffID.setEditable(false);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblPaymentType);
        boxes4.add(jrbCash);
        boxes4.add(jrbCreditCard);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblTicketPrice);
        boxes5.add(jtfTicketPrice);
        jtfTicketPrice.setEditable(false);
        jtfTicketPrice.setText(String.format("%.2f",a ));
        //jtfTicketPrice.setText(String.format("%d", 20));
        
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblQuantity);
        boxes6.add(jtfQuantity);
        jtfQuantity.setEditable(false);
        //jtfQuantity.setText(String.format("%d", 2));
        jtfQuantity.setText(String.format("%d",c));
        double cal1 = Double.parseDouble(jtfQuantity.getText());
        double cal =  Double.parseDouble(jtfTicketPrice.getText());
        
        double cal2 = cal1*cal;
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblAmount);
        boxes7.add(jtfAmount);
        jtfAmount.setText(String.format("%.2f",cal2));
        jtfAmount.setEditable(false);
        
        
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblPay);
        boxes8.add(jtfPay);
        
       
        
        JPanel p1 = new JPanel(new GridLayout(8,1));
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes6);
        p1.add(boxes7);
        p1.add(boxes8);
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtPay);
        add(LastPanel);
        
        setTitle("Payment");
        setUndecorated(true);
        setSize(500,500);
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jbtPay.addActionListener(new PaymentFunction());
    }
    
    private class PaymentFunction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int Valid =1;
        Payment payment = paymentMaintain.selectRecord(jtfPaymentID.getText());   
        
        if(jtfPay.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill up pay amount");
            Valid=0;
        }
        if(!jtfPay.getText().matches("[0-9]+.[0-9]+")&&!jtfPay.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Pay amount must double number. e.g:12.30");
            Valid=0;
        }
        if(!jrbCash.isSelected()&&!jrbCreditCard.isSelected()){
                     JOptionPane.showMessageDialog(null, "Plese fill up all information");
                     Valid=0;
                }
        if(Valid==0){
            
        }
        else{
            
            if(jrbCash.isSelected()){
                     jtfPaymentType = jrbCash.getText();
                }
                if(jrbCreditCard.isSelected()){
                     jtfPaymentType = jrbCreditCard.getText();
                }
        double pay = Double.parseDouble(jtfAmount.getText());
        double pay1 =  Double.parseDouble(jtfPay.getText());
        int payy =1;
       double pay3 = pay1 - pay;
       if(pay1<pay){
           JOptionPane.showMessageDialog(null, "Payment Money is not enough.");
           payy=0;
       }
       if(payy==0){
           
       }
       else{
       JOptionPane.showMessageDialog(null, "Receipt:\n Ticket Price:"+jtfTicketPrice.getText()+"\nQuantity:"+jtfQuantity.getText()+"\nTotal Amount:"+jtfAmount.getText()+"\nPay:"+jtfPay.getText()+"\nChange:"+pay3);
            
         payment = new Payment(jtfPaymentID.getText(),Double.parseDouble(jtfAmount.getText()),staff.getID(),jtfPurchaseID.getText(),jtfPaymentType,Integer.parseInt(jtfQuantity.getText()));
         paymentMaintain.addRecord(payment);
         setVisible(false);
       }
        }
                
        }
    }
        
    
    
    public static void main(String[] args) {
        //new PayPayment();
    }
    
}


