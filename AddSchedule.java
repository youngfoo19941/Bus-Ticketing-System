package ui;
import domain.Schedule;
//import da.ScheduleDA;
import control.MaintainSchedule;
import domain.Staff;
import da.StaffDA;
import control.MaintainStaff;
import domain.busInfo;
import da.BusInfoDA;
import control.MaintainBus;
import domain.Seat;
import da.SeatDA;
import control.MaintainSeat;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.lang.ArrayIndexOutOfBoundsException;


//import java.util.ArrayList;

public class AddSchedule extends JFrame{
    private MaintainSchedule scheduleMaintain = new MaintainSchedule();
    //ImageIcon a = new ImageIcon(getClass().getResource("/images/blur.jpg"));
    //private MaintainSchedule scheduleMaintain;
    private MaintainStaff staffMaintain;
    private MaintainBus busMaintain;
    private MaintainSeat seatMaintain = new MaintainSeat();
    private JLabel jlblScheduleID = new JLabel("     Schedule ID:        ");
    private JTextField jtfScheduleID = new JTextField(10);
    private JLabel jlblDeparture = new JLabel("     Departure:           ");
    private JTextField jtfDeparture = new JTextField(10);
    private JLabel jlblDestination = new JLabel("     Destination:         ");
    private JTextField jtfDestination = new JTextField();
    private JLabel jlblBusID = new JLabel("     Bus ID:                  ");
    //private JTextField jtfBusID = new JTextField();
    private JLabel jlblTicketPrice = new JLabel("     Ticket Price:       ");
    private JTextField jtfTicketPrice = new JTextField();
    
    //add JPanel to the contentPane
    //private JPanel contentPane;
    
    private JLabel jlblDate = new JLabel("    Date:                      ");
    private JTextField jtfDate = new JTextField();
    private JLabel jlblTime = new JLabel("     Time:                    ");
    private JTextField jtfTime = new JTextField();
    
    private JLabel jlblStaffID = new JLabel("    Staff ID:                 ");
    //private JTextField jtfStaffID = new JTextField();
    private JLabel jlblSeatID = new JLabel("    Seat ID:                 ");
    private JTextField jtfSeatID = new JTextField();
    
    
    
    private JButton btnNewButton = new JButton("...");
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtCancel = new JButton("Cancel");
  
    public AddSchedule(){
 
        String staffid = scheduleMaintain.selectRecord1();
        String b1 = staffid.substring(1,5);
        int c = Integer.parseInt(b1)+1;
        String scheduleID = "A"+String.format("%d", c);
        jtfScheduleID.setText(scheduleID);
        jtfScheduleID.setEditable(false);
        
        String seatid = seatMaintain.getID();
        String b2 = seatid.substring(1,5);
        int d = Integer.parseInt(b2)+1;
        String seatID = "S"+String.format("%d", d);
        jtfSeatID.setText(seatID);
        
        
        //set bounds of text field
        jtfDate.setBounds(101, 107, 86, 20);
        //set columns
        jtfDate.setColumns(10);
        jtfDate.setEditable(false);
        
        //seatMaintain = new MaintainSeat();
        //String[] seat = seatMaintain.getAllSeatID();
        staffMaintain = new MaintainStaff();
        String[] staff = staffMaintain.getid();
        JComboBox a = new JComboBox(staff);
        
        busMaintain = new MaintainBus();
        String[] bus = busMaintain.getAllBusID();
        JComboBox b = new JComboBox(bus);
        
        
        
  
        scheduleMaintain = new MaintainSchedule();
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblScheduleID);
        boxes1.add(jtfScheduleID);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblDeparture);
        boxes2.add(jtfDeparture);
        jtfDeparture.setEditable(false);
        jtfDeparture.setText("Kampar");
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblDestination);
        boxes3.add(jtfDestination);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblBusID);
        boxes4.add(b);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblTicketPrice);
        boxes5.add(jtfTicketPrice);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblDate);
        boxes6.add(jtfDate);
        boxes6.add(btnNewButton);
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblTime);
        boxes7.add(jtfTime);
        
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblStaffID);
        boxes8.add(a);
        
        Box boxes9 = Box.createHorizontalBox();
        boxes9.add(jlblSeatID);
        boxes9.add(jtfSeatID);
       jtfSeatID.setEditable(false);
        
        
        
        JPanel p1 = new JPanel(new GridLayout(9,1,10,10));
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
       
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtAdd);
        LastPanel.add(jbtCancel);
        add(LastPanel);
        
        
        
        jbtAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int validationFlag;
        try{    
            
            
            
            validationFlag=1;
            if(!jtfDestination.getText().matches("[A-Z a-z]*")&&!jtfDestination.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Destination can not enter number. e.g: Gopeng");
                validationFlag=0;
            }
            if(!jtfTicketPrice.getText().matches("[0-9]+.[0-9]+")&&!jtfTicketPrice.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Price must double number. e.g:12.30");
                validationFlag=0;
            }
             if(!jtfTime.getText().matches("([01]?[0-9]|2[0-3]).[0-5][0-9]")&&!jtfTime.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Time format Wrong.The format is 24-hours mode. e.g: 12.30");
                validationFlag=0;
            }
             if(jtfDate.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill up all infomation");
                validationFlag=0;
            }
            
             if(validationFlag==0){
                
            }  
 
            else{
                 
                String jtfstaffID="";
                for(int i=0; i<31 ;i++){
                    if(a.getSelectedIndex()== i){
                           jtfstaffID += staff[i];
                    }
                }
                String jtfBusID="";
                for(int i=0; i<31 ;i++){
                    if(b.getSelectedIndex()== i){
                           jtfBusID += bus[i];
                           
                    }
                }
                
                Schedule schedule = scheduleMaintain.selectRecord(jtfScheduleID.getText());
                //Seat seat = seatMaintain.selectRecord(jtfSeatID.getText());
                int yes=1;
                
                yes = JOptionPane.showConfirmDialog(null, "Are you sure to add?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(yes==JOptionPane.YES_OPTION){
                 
                    Seat seat = new Seat(jtfSeatID.getText(),true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true);
                    seatMaintain.addRecord(seat);
                    
                    schedule = new Schedule(jtfScheduleID.getText(),jtfDeparture.getText(),jtfDestination.getText(), jtfBusID, jtfstaffID, Double.parseDouble(jtfTicketPrice.getText()),jtfDate.getText(),jtfSeatID.getText(), jtfTime.getText());
                    scheduleMaintain.addRecord(schedule);
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Schedule Added");
                    
                    setVisible(false);
                }
                
            }
                 
            
        }catch(IllegalArgumentException ex){
            if(jtfDestination.getText().endsWith("")||jtfTicketPrice.getText().endsWith("")||jtfTime.getText().endsWith(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill up all Schedule Information !", "Invalid Add", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        }});
        
       
        
        jbtCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        btnNewButton.addActionListener(new ActionListener(){ 
            //performed action
            public void actionPerformed(ActionEvent arg0){
                //create frame new object  f
                 final JFrame f = new JFrame();
                //set text which is collected by date picker i.e. set date 
                jtfDate.setText(new ui.DatePicker(f).setPickedDate());
                }
            });
 
        
        
        

        setTitle("Add New Schedule");
        //setUndecorated(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    
    public static void main(String[] args) {
        new AddSchedule();
    }
    
    
 
    
}
