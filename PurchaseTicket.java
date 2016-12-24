
package ui;

import domain.Seat;
import da.SeatDA;
import control.MaintainSeat;
import domain.Purchase;
import da.PurchaseDA;
import control.MaintainPurchase;
import domain.Schedule;
import da.ScheduleDA;
import control.MaintainSchedule;
import domain.Staff;

import domain.busInfo;
import da.BusInfoDA;
import control.MaintainBus;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PurchaseTicket extends JFrame{

    ImageIcon seatIcon = new ImageIcon(getClass().getResource("/images/seat.png"));
    ImageIcon ticketIcon = new ImageIcon(getClass().getResource("/images/ticket_icon.png"));
    private MaintainSeat seatMaintain = new MaintainSeat();
    private MaintainPurchase purchaseMaintain = new MaintainPurchase();
    private MaintainSchedule scheduleMaintain = new MaintainSchedule();
     private MaintainBus busMaintain = new MaintainBus();
    private JLabel jlblPurchaseID = new JLabel("     Puchase ID:                        ");
    private JTextField jtfPurchaseID = new JTextField();
    private JLabel jlblCustomerName = new JLabel("     Customer Name:              ");
    private JTextField jtfCustomerName = new JTextField();
    private JLabel jlblSeatID = new JLabel("     Seat ID:                                ");
    private JTextField jtfSeatID = new JTextField();
    private JLabel jlblPurchaseDate = new JLabel("     Purchase Date:                 ");
    private JTextField jtfPurchaseDate = new JTextField();
    private JLabel jlblCustomerContact = new JLabel("     Customer Contact:           ");
    private JTextField jtfCustomerContact = new JTextField();
    private JLabel jlblScheduleID = new JLabel("     Schedule ID:                       ");
    //private JTextField jtfScheduleID = new JTextField();
    private JLabel jlblCustomerIC = new JLabel("    Customer IC:                       ");
    private JTextField jtfCustomerIC = new JTextField();
    //ImageIcon seatImage = new ImageIcon(getClass().getResource("/images/seat.png"));
    
    private JLabel jlblDeparture = new JLabel("     Dparture:                             ");
    private JTextField jtfDeparture = new JTextField("Kampar");
    private JLabel jlblDate = new JLabel("     Date:                                     ");
    private JTextField jtfDate = new JTextField();
    private JLabel jlblTime = new JLabel("     Time:                                    ");
    private JTextField jtfTime = new JTextField();
    private JLabel jlblDestination = new JLabel("     Destination:                        ");
    private JTextField jtfDestination = new JTextField();
    private JButton jbtCheck = new JButton("Check");
    private Boolean seat1,seat2,seat3,seat4,seat5,seat6,seat7,
            seat8,seat9,seat10,seat11,seat12,seat13,seat14,seat15,
            seat16,seat17,seat18,seat19,seat20;
   
    private static JToggleButton[] buttons  = new JToggleButton[21];
    private JButton jbtPayment = new JButton("Pay");
    private JButton jbtCancel = new JButton("Cancel");
    private String jtfScheduleID="";
    private double jtftPrice=0;
    private int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20;
    
    Staff staff = new Staff();
    public PurchaseTicket(Staff staff){
        this.staff = staff;
        JPanel panel = new JPanel();
        //panel.setSize(230, 370);
        panel.setLayout(new GridLayout(5, 4));
        
        scheduleMaintain = new MaintainSchedule();
        String[] schedule = scheduleMaintain.getscheduleID();
       
        JComboBox scID = new JComboBox(schedule);
         double[] tp = scheduleMaintain.getTicketPrice1();
        
        
        
        String[] seaID = seatMaintain.getAllSeatID();
        String[] des = scheduleMaintain.getScheduleDestination();
        
        String[] t = scheduleMaintain.getscheduleTime();
        String[] d = scheduleMaintain.getscheduleDate();
        
        
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
	   Date date = new Date();
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	   String date1 = df.format(date);
           

        
        String purchaseid = purchaseMaintain.selectRecord1();
        String b = purchaseid.substring(1,5);
        int c = Integer.parseInt(b)+1;
        String purchaseID = "R"+String.format("%d", c);
    
        jtfPurchaseID.setText(purchaseID);
        jtfPurchaseID.setEditable(false);
        
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblPurchaseID);
        boxes1.add(jtfPurchaseID);
        add(boxes1);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblScheduleID);
        boxes2.add(scID);
        boxes2.add(jbtCheck);
        add(boxes2);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblDeparture);
        boxes3.add(jtfDeparture);
        add(boxes3);
        jtfDeparture.setEditable(false);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblDestination);
        boxes4.add(jtfDestination);
        add(boxes4);
        jtfDestination.setEditable(false);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblSeatID);
        boxes5.add(jtfSeatID);
        add(boxes5);
        jtfSeatID.setEditable(false);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblDate);
        boxes6.add(jtfDate);
        add(boxes6);
        jtfDate.setEditable(false);
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblTime);
        boxes7.add(jtfTime);
        add(boxes7);
        jtfTime.setEditable(false);
        
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblPurchaseDate);
        boxes8.add(jtfPurchaseDate);
        add(boxes8);
        jtfPurchaseDate.setText(date1);
        jtfPurchaseDate.setEditable(false);
        
        Box boxes9 = Box.createHorizontalBox();
        boxes9.add(jlblCustomerName);
        boxes9.add(jtfCustomerName);
        add(boxes9);
        

        
        Box boxes10 = Box.createHorizontalBox();
        boxes10.add(jlblCustomerContact);
        boxes10.add(jtfCustomerContact);
        add(boxes10);
        
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblCustomerIC);
        boxes11.add(jtfCustomerIC);
        add(boxes11);
        
        JPanel p1 = new JPanel(new GridLayout(11,1));
        p1.setOpaque(false);
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes6);
        p1.add(boxes7);
        p1.add(boxes8);
        p1.add(boxes9);
        p1.add(boxes10);
        p1.add(boxes11);
        
        add(p1);
        //jbtPayment.setEnabled(false);
        
        
        for(int i=1;i<buttons.length;i++){
             buttons[i] = new JToggleButton(""+i);
             buttons[i].setIcon(seatIcon);
             buttons[i].setEnabled(false);
             buttons[i].setBorder(null);
             
             buttons[i].addActionListener(new buttonFunction());
             panel.add(buttons[i]);
        }
        jbtPayment.setEnabled(false);
        
        
        JPanel BigPanel = new JPanel(new GridLayout(1,2));
        BigPanel.add(p1, BorderLayout.EAST);
        BigPanel.add(panel, BorderLayout.WEST);
        add(BigPanel);
        JPanel last = new JPanel(new FlowLayout());
        last.add(jbtPayment);
        last.add(jbtCancel);
        add(last,BorderLayout.SOUTH);
        
        
        jbtCheck.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jbtPayment.setEnabled(true);
                for(int i=0; i<schedule.length ;i++){
                    if(scID.getSelectedIndex()== i){
                           jtfScheduleID = schedule[i];
                           jtftPrice = tp[i];
                           jtfSeatID.setText(seaID[i]);
                           jtfDestination.setText(des[i]);
                           jtfDate.setText(d[i]);
                           jtfTime.setText(t[i]);
                           
                    }
                }
                Seat seat = seatMaintain.selectRecord(jtfSeatID.getText());
                //Schedule sch = scheduleMaintain.selectRecord(jtfScheduleID);
                //double tp = sch.getTicketPrice();
               
                 if(jtfSeatID.getText().equals(seat.getSeatID())){   
                    if(seat.getSeatNo1()==false){
                        buttons[1].setEnabled(false);
                    }
                    if(seat.getSeatNo2()==false){
                        buttons[2].setEnabled(false);
                    }
                    if(seat.getSeatNo3()==false){
                        buttons[3].setEnabled(false);
                    }
                    if(seat.getSeatNo4()==false){
                        buttons[4].setEnabled(false);
                    }
                    if(seat.getSeatNo5()==false){
                        buttons[5].setEnabled(false);
                    }
                    if(seat.getSeatNo6()==false){
                        buttons[6].setEnabled(false);
                    }
                    if(seat.getSeatNo7()==false){
                        buttons[7].setEnabled(false);
                    }
                    if(seat.getSeatNo8()==false){
                        buttons[8].setEnabled(false);
                    }
                    if(seat.getSeatNo9()==false){
                        buttons[9].setEnabled(false);
                    }
                    if(seat.getSeatNo10()==false){
                        buttons[10].setEnabled(false);
                    }
                    if(seat.getSeatNo11()==false){
                        buttons[11].setEnabled(false);
                    }
                    if(seat.getSeatNo12()==false){
                        buttons[12].setEnabled(false);
                    }
                    if(seat.getSeatNo13()==false){
                        buttons[13].setEnabled(false);
                    }
                    if(seat.getSeatNo14()==false){
                        buttons[14].setEnabled(false);
                    }
                    if(seat.getSeatNo15()==false){
                        buttons[15].setEnabled(false);
                    }
                    if(seat.getSeatNo16()==false){
                        buttons[16].setEnabled(false);
                    }
                    if(seat.getSeatNo17()==false){
                        buttons[17].setEnabled(false);
                    }
                    if(seat.getSeatNo18()==false){
                        buttons[18].setEnabled(false);
                    }
                    if(seat.getSeatNo19()==false){
                        buttons[19].setEnabled(false);
                    }
                    if(seat.getSeatNo20()==false){
                        buttons[20].setEnabled(false);
                    }
                 if(seat.getSeatNo1()==true){
                        buttons[1].setEnabled(true);
                    }
                    if(seat.getSeatNo2()==true){
                        buttons[2].setEnabled(true);
                    }
                    if(seat.getSeatNo3()==true){
                        buttons[3].setEnabled(true);
                    }
                    if(seat.getSeatNo4()==true){
                        buttons[4].setEnabled(true);
                    }
                    if(seat.getSeatNo5()==true){
                        buttons[5].setEnabled(true);
                    }
                    if(seat.getSeatNo6()==true){
                        buttons[6].setEnabled(true);
                    }
                    if(seat.getSeatNo7()==true){
                        buttons[7].setEnabled(true);
                    }
                    if(seat.getSeatNo8()==true){
                        buttons[8].setEnabled(true);
                    }
                    if(seat.getSeatNo9()==true){
                        buttons[9].setEnabled(true);
                    }
                    if(seat.getSeatNo10()==true){
                        buttons[10].setEnabled(true);
                    }
                    if(seat.getSeatNo11()==true){
                        buttons[11].setEnabled(true);
                    }
                    if(seat.getSeatNo12()==true){
                        buttons[12].setEnabled(true);
                    }
                    if(seat.getSeatNo13()==true){
                        buttons[13].setEnabled(true);
                    }
                    if(seat.getSeatNo14()==true){
                        buttons[14].setEnabled(true);
                    }
                    if(seat.getSeatNo15()==true){
                        buttons[15].setEnabled(true);
                    }
                    if(seat.getSeatNo16()==true){
                        buttons[16].setEnabled(true);
                    }
                    if(seat.getSeatNo17()==true){
                        buttons[17].setEnabled(true);
                    }
                    if(seat.getSeatNo18()==true){
                        buttons[18].setEnabled(true);
                    }
                    if(seat.getSeatNo19()==true){
                        buttons[19].setEnabled(true);
                    }
                    if(seat.getSeatNo20()==true){
                        buttons[20].setEnabled(true);
                    }
                    
                 }
                 
                 
                
            }
            });
        
        jbtPayment.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //setVisible(false);
                Schedule schedule = scheduleMaintain.selectRecord(jtfScheduleID);
                Seat seat = seatMaintain.selectRecord(jtfSeatID.getText());
                busInfo bus = busMaintain.selectRecord(schedule.getBusID());
                
                    seat1 = seat.getSeatNo1();seat2 = seat.getSeatNo2();seat3 = seat.getSeatNo3();seat4 = seat.getSeatNo4();seat5 = seat.getSeatNo5();
                    seat6 = seat.getSeatNo6();seat7 = seat.getSeatNo7();seat8 = seat.getSeatNo8();seat9 = seat.getSeatNo9();seat10 = seat.getSeatNo10();
                    seat11 = seat.getSeatNo11();seat12 = seat.getSeatNo12();seat13 = seat.getSeatNo13();seat14 = seat.getSeatNo14();seat15 = seat.getSeatNo15();
                    seat16 = seat.getSeatNo16();seat17 = seat.getSeatNo17();seat18 = seat.getSeatNo18();seat19 = seat.getSeatNo19();seat20 = seat.getSeatNo20();   
                    int c=0;
                    
                    if(jtfSeatID.getText().equals(seat.getSeatID())){   
                    if(seat1=buttons[1].isSelected()){
                        c++;
                        a1=1;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a1+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat2=buttons[2].isSelected()){
                        c++;
                        a2=2;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a2+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat3=buttons[3].isSelected()){
                        c++;
                        a3=3;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a3+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat4=buttons[4].isSelected()){
                        c++;
                        a4=4;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a4+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat5=buttons[5].isSelected()){
                        c++;
                        a5=5;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a5+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat6=buttons[6].isSelected()){
                        c++;
                        a6=6;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a6+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat7=buttons[7].isSelected()){
                        c++;
                        a7=7;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a7+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat8=buttons[8].isSelected()){
                        c++;
                        a8=8;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a8+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat9=buttons[9].isSelected()){
                        c++;
                        a9=9;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a9+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat10=buttons[10].isSelected()){
                        c++;
                        a10=10;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a10+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat11=buttons[11].isSelected()){
                        c++;
                        a11=11;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a11+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat12=buttons[12].isSelected()){
                        c++;
                        a12=12;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a12+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat13=buttons[13].isSelected()){
                        c++;
                        a13=13;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a13+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat14=buttons[14].isSelected()){
                        c++;
                        a14=14;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a14+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat15=buttons[15].isSelected()){
                        c++;
                        a15=15;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a15+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat16=buttons[16].isSelected()){
                        c++;
                        a16=16;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a16+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat17=buttons[17].isSelected()){
                        c++;
                        a17=17;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a17+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat18=buttons[18].isSelected()){
                        c++;
                        a18=18;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a18+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat19=buttons[19].isSelected()){
                        c++;
                        a19=19;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a19+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    if(seat20=buttons[20].isSelected()){
                        c++;
                        a20=20;
                        JOptionPane.showMessageDialog(null, "Seat No : "+a20+"\nBus No : "+bus.getbusNo()+"\nDeparture :"+schedule.getDeparture()
                                                            +"\nDestination : "+schedule.getDestination()+"\nTime : "+schedule.getTime()+"\nTicketPrice : "+schedule.getTicketPrice(),"Ticket",JOptionPane.INFORMATION_MESSAGE,ticketIcon);
                        
                    }
                    }
                    
                    //JOptionPane.showMessageDialog(null, c);
                    
                    
                int Valid = 1;
                 Purchase purchase=purchaseMaintain.selectRecord(jtfPurchaseID.getText());
               
                 if(jtfCustomerName.getText().equals("")||jtfCustomerContact.getText().equals("")){
                     JOptionPane.showMessageDialog(null, "Please fill up all information");
                Valid=0;
                 }
                 if(!jtfCustomerName.getText().matches("[A-Z a-z]*")&&!jtfCustomerName.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Name must be enter alphebet. eg.Tey Choon Wei");
                Valid=0;
                 }
                 
                 if(!jtfCustomerContact.getText().matches("[0-9]*")&&!jtfCustomerContact.getText().isEmpty()||jtfCustomerContact.getText().length()!=10){
                JOptionPane.showMessageDialog(null, "Phone number format incorrect.Must be 10-digit number. eg.0154471133");
                Valid=0;
                 }
                 if(!jtfCustomerIC.getText().matches("[0-9]*")&&!jtfCustomerIC.getText().isEmpty()||jtfCustomerIC.getText().length()!=12){
                JOptionPane.showMessageDialog(null, "IC format incorrect.Must be 12-digit number. eg.0154471133");
                Valid=0;
                 }
                 
                 if(Valid==0){}
                 
                 if(c!=0&&!jtfCustomerName.getText().equals("")&&!jtfCustomerContact.getText().equals("")&&!jtfCustomerIC.getText().equals("")){
                       
                        purchase = new Purchase(jtfPurchaseID.getText(),jtfCustomerName.getText(),jtfSeatID.getText(),jtfCustomerContact.getText(),jtfScheduleID,jtfCustomerIC.getText(),jtfPurchaseDate.getText());
                        purchaseMaintain.getRecord(purchase);
                        
                        new PayPayment(c,jtftPrice,staff);
                        
                    }
                 else{
                     JOptionPane.showMessageDialog(null, "Please select seat.");
                 }
                    
                
            }
            });
        jbtCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        
        
        
        
        
        
        setTitle("Purchase Ticket");
        setUndecorated(true);
        //setSize(700,500);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
     private class buttonFunction implements ActionListener {

        @Override
    public void actionPerformed(ActionEvent e) {
        Seat seat = seatMaintain.selectRecord(jtfSeatID.getText());
    //Object source = e.getSource();
        seat1 = seat.getSeatNo1();seat2 = seat.getSeatNo2();seat3 = seat.getSeatNo3();seat4 = seat.getSeatNo4();seat5 = seat.getSeatNo5();
        seat6 = seat.getSeatNo6();seat7 = seat.getSeatNo7();seat8 = seat.getSeatNo8();seat9 = seat.getSeatNo9();seat10 = seat.getSeatNo10();
        seat11 = seat.getSeatNo11();seat12 = seat.getSeatNo12();seat13 = seat.getSeatNo13();seat14 = seat.getSeatNo14();seat15 = seat.getSeatNo15();
        seat16 = seat.getSeatNo16();seat17 = seat.getSeatNo17();seat18 = seat.getSeatNo18();seat19 = seat.getSeatNo19();seat20 = seat.getSeatNo20();
    if (e.getSource() == buttons[1]) {
       if(seat1=buttons[1].isSelected())
        seat1 =false;
       buttons[1].setEnabled(false);
       
        
    } 
    if(e.getSource() == buttons[2]){
       if(seat2=buttons[2].isSelected())
        seat2 =false;
       buttons[2].setEnabled(false);
    }
    if(e.getSource() == buttons[3]){
       if(seat3=buttons[3].isSelected())
        seat3 =false;
       buttons[3].setEnabled(false);
    }
    if(e.getSource() == buttons[4]){
        if(seat4=buttons[4].isSelected())
        seat4 =false;
        buttons[4].setEnabled(false);
    }
    
    if(e.getSource() == buttons[5]){
        if(seat5=buttons[5].isSelected())
        seat5 =false;
        buttons[5].setEnabled(false);
    }
    if(e.getSource() == buttons[6]){
        if(seat6=buttons[6].isSelected())
        seat6 =false;
        buttons[6].setEnabled(false);
    }
    if(e.getSource() == buttons[7]){
        if(seat7=buttons[7].isSelected())
        seat7 =false;
        buttons[7].setEnabled(false);
    }
    if(e.getSource() == buttons[8]){
        if(seat8=buttons[8].isSelected())
        seat8 =false;
        buttons[8].setEnabled(false);
    }
    if(e.getSource() == buttons[9]){
        if(seat9=buttons[9].isSelected())
        seat9 =false;
        buttons[9].setEnabled(false);
    }
    if(e.getSource() == buttons[10]){
        if(seat10=buttons[10].isSelected())
        seat10 =false;
        buttons[10].setEnabled(false);
    }
    if(e.getSource() == buttons[11]){
        if(seat11=buttons[11].isSelected())
        seat11 =false;
        buttons[11].setEnabled(false);
    }
    if(e.getSource() == buttons[12]){
        if(seat12=buttons[12].isSelected())
        seat12 =false;
        buttons[12].setEnabled(false);
    }
    if(e.getSource() == buttons[13]){
       if(seat13=buttons[13].isSelected())
        seat13 =false;
       buttons[13].setEnabled(false);
    }
    if(e.getSource() == buttons[14]){
        if(seat14=buttons[14].isSelected())
        seat14 =false;
        buttons[14].setEnabled(false);
    }
    if(e.getSource() == buttons[15]){
        if(seat15=buttons[15].isSelected())
        seat15 =false;
        buttons[15].setEnabled(false);
    }
    if(e.getSource() == buttons[16]){
       if(seat16=buttons[16].isSelected())
        seat16 =false;
       buttons[16].setEnabled(false);
    }
    if(e.getSource() == buttons[17]){
        if(seat17=buttons[17].isSelected())
        seat17 =false;
        buttons[17].setEnabled(false);
    }
    if(e.getSource() == buttons[18]){
        if(seat18=buttons[18].isSelected())
        seat18 =false;
        buttons[18].setEnabled(false);
    }
    if(e.getSource() == buttons[19]){
        if(seat19=buttons[19].isSelected())
        seat19 =false;
        buttons[19].setEnabled(false);
    }
    if(e.getSource() == buttons[20]){
        if(seat20=buttons[20].isSelected())
        seat20 =false;
        buttons[20].setEnabled(false);
    }
    seat = new Seat(jtfSeatID.getText(),seat1,seat2,seat3,seat4,seat5,seat6,seat7,seat8,seat9,seat10,seat11,seat12,seat13,seat14,seat15,seat16,seat17,seat18,seat19,seat20);
                    seatMaintain.updateRecord(seat);
                    

                 
        
    
}
     }
     
    
    public static void main(String[] args) {
        //new PurchaseTicket();
    }
    
}
