package ui;
//import control.MaintainSchedule;
import control.MaintainStaff;
import da.StaffDA;
import control.MaintainSchedule;
import control.MaintainStaff;
import da.ScheduleDA;
import domain.Schedule;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import domain.busInfo;
import da.BusInfoDA;
import control.MaintainBus;
import domain.Seat;
import da.SeatDA;
import control.MaintainSeat;



public class UpdateSchedule1 extends JFrame{
    private MaintainStaff staffMaintain;
    private MaintainSchedule scheduleMaintain;
    private MaintainBus busMaintain;
    private MaintainSeat seatMaintain;
    private JLabel jlblScheduleID = new JLabel("     Schedule ID:        ");
    private JTextField jtfScheduleID = new JTextField(10);
    private JLabel jlblScheduleID2 = new JLabel("     Schedule ID:        ");
    private JTextField jtfScheduleID2 = new JTextField(10);
    private JLabel jlblDeparture = new JLabel("     Departure:           ");
    private JTextField jtfDeparture = new JTextField(10);
    private JLabel jlblDeparture2 = new JLabel("     Departure:           ");
    private JTextField jtfDeparture2 = new JTextField(10);
    private JLabel jlblDestination = new JLabel("     Destination:         ");
    private JTextField jtfDestination = new JTextField();
    private JLabel jlblDestination2 = new JLabel("     Destination:         ");
    private JTextField jtfDestination2 = new JTextField();
    private JLabel jlblBusID = new JLabel("     Bus ID:                  ");
    private JTextField jtfBusID = new JTextField();
    private JLabel jlblBusID2 = new JLabel("     Bus ID:                  ");
   // private JTextField jtfBusID2 = new JTextField();
    private JLabel jlblTicketPrice = new JLabel("     Ticket Price RM:");
    private JTextField jtfTicketPrice = new JTextField();
    private JLabel jlblTicketPrice2 = new JLabel("     Ticket Price RM:");
    private JTextField jtfTicketPrice2 = new JTextField();
    
    
    
    private JLabel jlblDate = new JLabel("    Date:                      ");
    private JTextField jtfDate = new JTextField();
    private JLabel jlblDate2 = new JLabel("    Date:                      ");
    private JTextField jtfDate2 = new JTextField();
    private JButton jbtDate =new JButton("...");
    
    private JLabel jlblTime = new JLabel("     Time:                    ");
    private JTextField jtfTime = new JTextField();
    private JLabel jlblTime2 = new JLabel("     Time:                    ");
    private JTextField jtfTime2 = new JTextField();
    
    private JLabel jlblStaffID = new JLabel("    Staff ID:                 ");
    private JTextField jtfStaffID = new JTextField();
    private JLabel jlblStaffID2 = new JLabel("    Staff ID:                 ");
    //private JTextField jtfStaffID2 = new JTextField();
    
    private JLabel jlblSeatID = new JLabel("    SeatID:                  ");
    private JTextField jtfSeatID = new JTextField();
    private JLabel jlblSeatID2 = new JLabel("    SeatID:                  ");
    private JTextField jtfSeatID2 = new JTextField();
    
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public UpdateSchedule1(String des){
        
        //seatMaintain = new MaintainSeat();
        //String[] seat = seatMaintain.getAllSeatID();
        busMaintain = new MaintainBus();
        String[] bus = busMaintain.getAllBusID();
        JComboBox b = new JComboBox(bus);
        
        staffMaintain = new MaintainStaff();
        String[] staff = staffMaintain.getid();
        JComboBox a = new JComboBox(staff);
        
        seatMaintain = new MaintainSeat();
        String[] seat = seatMaintain.getAllSeatID();
        
        
        scheduleMaintain = new MaintainSchedule();
        Schedule schedule = scheduleMaintain.getDestination(des);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblScheduleID);
        boxes1.add(jtfScheduleID);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblDeparture);
        boxes2.add(jtfDeparture);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblDestination);
        boxes3.add(jtfDestination);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblBusID);
        boxes4.add(jtfBusID);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblTicketPrice);
        boxes5.add(jtfTicketPrice);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblDate);
        boxes6.add(jtfDate);
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblTime);
        boxes7.add(jtfTime);
        
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblStaffID);
        boxes8.add(jtfStaffID);
        
        Box boxes9 = Box.createHorizontalBox();
        boxes9.add(jlblSeatID);
        boxes9.add(jtfSeatID);
       

        JPanel p1 = new JPanel(new GridLayout(9,1));
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder("Current Schedule Information"));
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes6);
        p1.add(boxes7);
        p1.add(boxes8);
        p1.add(boxes9);
     
        add(p1);
        
        
        jtfScheduleID.setText(String.format("%s",schedule.getScheduleID()));
        jtfScheduleID.setEditable(false);
        jtfScheduleID2.setText(String.format("%s",schedule.getScheduleID()));
        jtfScheduleID2.setEditable(false);
        jtfDeparture.setText(String.format("%s",schedule.getDeparture()));
        jtfDeparture.setEditable(false);
        jtfDestination.setText(String.format("%s",schedule.getDestination()));
        jtfDestination.setEditable(false);
        jtfBusID.setText(String.format("%s",schedule.getBusID()));
        jtfBusID.setEditable(false);
        jtfStaffID.setText(String.format("%s",schedule.getStaffID()));
        jtfStaffID.setEditable(false);
        jtfTime.setText(String.format("%s",schedule.getTime()));
        jtfTime.setEditable(false);
        jtfDate.setText(String.format("%s",schedule.getDate()));
        jtfDate.setEditable(false);
        jtfTicketPrice.setText(String.format("%s",schedule.getTicketPrice()));
        jtfTicketPrice.setEditable(false);
        jtfSeatID.setText(String.format("%s",schedule.getSeatID()));
        jtfSeatID.setEditable(false);
        
        
        
        Box boxes10 = Box.createHorizontalBox();
        boxes10.add(jlblScheduleID2);
        boxes10.add(jtfScheduleID2);
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblDeparture2);
        boxes11.add(jtfDeparture2);
        jtfDeparture2.setEditable(false);
        jtfDeparture2.setText(jtfDeparture.getText());
        
        Box boxes12 = Box.createHorizontalBox();
        boxes12.add(jlblDestination2);
        boxes12.add(jtfDestination2);
        
        Box boxes13 = Box.createHorizontalBox();
        boxes13.add(jlblBusID2);
        boxes13.add(b);
        
        Box boxes14 = Box.createHorizontalBox();
        boxes14.add(jlblTicketPrice2);
        boxes14.add(jtfTicketPrice2);
        
        Box boxes15 = Box.createHorizontalBox();
        boxes15.add(jlblDate2);
        boxes15.add(jtfDate2);
        boxes15.add(jbtDate);
        
        Box boxes16 = Box.createHorizontalBox();
        boxes16.add(jlblTime2);
        boxes16.add(jtfTime2);
        
        
        Box boxes17 = Box.createHorizontalBox();
        boxes17.add(jlblStaffID2);
        boxes17.add(a);
        
        Box boxes18 = Box.createHorizontalBox();
        boxes18.add(jlblSeatID2);
        boxes18.add(jtfSeatID2);
        jtfSeatID2.setEditable(false);
        jtfSeatID2.setText(jtfSeatID.getText());
        
        JPanel p2 = new JPanel(new GridLayout(9,1));
        p2.setOpaque(false);
        p2.setBorder(new TitledBorder("Updatet Schedule Information"));
        p2.add(boxes10);
        p2.add(boxes11);
        p2.add(boxes12);
        p2.add(boxes13);
        p2.add(boxes14);
        p2.add(boxes15);
        p2.add(boxes16);
        p2.add(boxes17);
        p2.add(boxes18);
     
        add(p2);
        
        
        JPanel BigPanel = new JPanel(new GridLayout(1,2));
        BigPanel.add(p1, BorderLayout.EAST);
        BigPanel.add(p2, BorderLayout.WEST);
        add(BigPanel);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtUpdate);
        LastPanel.add(jbtReset);
        LastPanel.add(jbtBack);
        add(LastPanel, BorderLayout.SOUTH);
        
        //jbtUpdate.addActionListener(new UpdateListener());
        jbtReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jtfDestination2.setText("");
                jtfTime2.setText("");
                jtfTicketPrice2.setText("");
            }
        });
        
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UpdateSchedule();
                setVisible(false);
            }
        });
        jbtDate.addActionListener(new ActionListener(){ 
            //performed action
            public void actionPerformed(ActionEvent arg0){
                //create frame new object  f
                 final JFrame f = new JFrame();
                //set text which is collected by date picker i.e. set date 
                jtfDate2.setText(new ui.DatePicker(f).setPickedDate());
                }
            });
        jtfDate2.setEditable(false);
        
        jbtUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            int validationFlag;
             String jtfStaffID2="";
                for(int i=0; i<31 ;i++){
                    if(a.getSelectedIndex()== i){
                           jtfStaffID2 += staff[i];
                    }
                }
                String jtfBusID2="";
                for(int i=0; i<31 ;i++){
                    if(b.getSelectedIndex()== i){
                           jtfBusID2 += bus[i];
                           
                    }
                }
                
            validationFlag = 1;
        Schedule schedule = scheduleMaintain.selectRecord(jtfScheduleID.getText());
            
            if(jtfDestination2.getText().equals("")){
                jtfDestination2.setText(jtfDestination.getText());
            }
            
            /*if(jtfStaffID2.getText().equals("")){
                jtfStaffID2.setText(jtfStaffID.getText());
            }*/
            if(jtfTime2.getText().equals("")){
                jtfTime2.setText(String.valueOf(jtfTime.getText()));
            }
            if(jtfTicketPrice2.getText().equals("")){
                jtfTicketPrice2.setText(String.format("%s",jtfTicketPrice.getText()));
            }
            if(jtfDate2.getText().equals("")){
                jtfDate2.setText(String.format("%s",jtfDate.getText()));
            }
            
            if(!jtfDestination2.getText().matches("[A-Z a-z]*")&&!jtfDestination2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Destination can not enter number. e.g: Gopeng");
                validationFlag=0;
            }
            if(!jtfTicketPrice2.getText().matches("[0-9]+.[0-9]+")&&!jtfTicketPrice2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Price format wrong. e.g:12.30");
                validationFlag=0;
            }
             if(!jtfTime2.getText().matches("([01]?[0-9]|2[0-3]).[0-5][0-9]")&&!jtfTime2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Time format Wrong.The format is 24-hours mode. e.g: 12.30");
                validationFlag=0;
            }
            if(validationFlag==0){
                
            }  
            
            
            
            else{
                     int yes = JOptionPane.showConfirmDialog(null,"Sure to Update Schedule information?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(yes==JOptionPane.YES_OPTION){
                 
             schedule = new Schedule(jtfScheduleID2.getText(),jtfDeparture2.getText(),jtfDestination2.getText(), jtfBusID2, jtfStaffID2, Double.parseDouble(jtfTicketPrice2.getText()),jtfDate2.getText(),jtfSeatID2.getText(), jtfTime2.getText());
                
              scheduleMaintain.updateRecord(schedule);
                 
              JOptionPane.showMessageDialog(null, "New Schedule Updated !");
             }
            } }});
        
       
        
        
        
        
        
        setTitle("Schedule CRUD");
        setSize(1000,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    
     
     
    public static void main(String[] args) {
        new UpdateSchedule1("Kuala Lumpur");
    }
    
}
