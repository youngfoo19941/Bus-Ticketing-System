package ui;
import control.MaintainSchedule;
import da.ScheduleDA;
import domain.Schedule;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteSchedule1 extends JFrame{

    private MaintainSchedule scheduleMaintain;
    private JLabel jlblScheduleID = new JLabel("     Schedule ID:        ");
    private JTextField jtfScheduleID = new JTextField(10);
    
    private JLabel jlblDestination = new JLabel("     Destination:         ");
    private JTextField jtfDestination = new JTextField();
    
    private JLabel jlblDeparture = new JLabel("     Departure:           ");
    private JTextField jtfDeparture = new JTextField(10);
    
    private JLabel jlblBusID = new JLabel("     Bus ID:                  ");
    private JTextField jtfBusID = new JTextField();
    
    private JLabel jlblTicketPrice = new JLabel("     Ticket Price:       ");
    private JTextField jtfTicketPrice = new JTextField();
   
    
    
    private JLabel jlblDate = new JLabel("    Date:                      ");
    private JTextField jtfDate = new JTextField();
    
    private JLabel jlblTime = new JLabel("     Time:                    ");
    private JTextField jtfTime = new JTextField();
    
    
    private JLabel jlblStaffID = new JLabel("    Staff ID:                 ");
    private JTextField jtfStaffID = new JTextField();
    
    private JLabel jlblSeatID = new JLabel("    Seat ID:                 ");
    private JTextField jtfSeatID = new JTextField();
    
    
    
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public DeleteSchedule1(String des){
        scheduleMaintain = new MaintainSchedule();
        Schedule schedule = scheduleMaintain.getDestination(des);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblScheduleID);
        boxes1.add(jtfScheduleID);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblDestination);
        boxes2.add(jtfDestination);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblDeparture);
        boxes3.add(jtfDeparture);
        
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
        jtfSeatID.setText(String.format("%s",schedule.getTicketPrice()));
        jtfSeatID.setEditable(false);
        
        
        
        
 
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtDelete);
        LastPanel.add(jbtBack);
        add(LastPanel, BorderLayout.SOUTH);
        
        jbtDelete.addActionListener(new DeleteListener());
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        setTitle("Schedule CRUD");
        setSize(600,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        Schedule schedule = scheduleMaintain.selectRecord(jtfScheduleID.getText());

                int i = JOptionPane.showConfirmDialog(null, "Are you sure delete?","Record Delete",JOptionPane.YES_NO_OPTION);
            
            if (schedule != null) {
              if(i==0){
                schedule = new Schedule(jtfScheduleID.getText(),jtfDeparture.getText(),jtfDestination.getText(), jtfBusID.getText(), jtfStaffID.getText(), Double.parseDouble(jtfTicketPrice.getText()),jtfDate.getText(),jtfSeatID.getText(),jtfTime.getText());
  
                scheduleMaintain.deleteRecord(schedule);
                
                JOptionPane.showMessageDialog(null, "Schedule Deleted! ");
                setVisible(false);
                new DeleteSchedule();
              }
            } else {
               JOptionPane.showMessageDialog(null, "Schedule ID are not exist","Schedule ID not found",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
 
     
     
    public static void main(String[] args) {
        new DeleteSchedule1("Kuala Lumpur");
    }
    
}
