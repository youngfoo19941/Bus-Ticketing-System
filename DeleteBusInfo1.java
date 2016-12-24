package ui;
import control.MaintainBus;
import da.BusInfoDA;
import domain.busInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteBusInfo1 extends JFrame{

    private MaintainBus busMaintain;
    private JLabel jlblBusID = new JLabel("     Bus ID:                  ");
    private JTextField jtfBusID = new JTextField(10);
    
    private JLabel jlblBusNo = new JLabel("     Bus No:                 ");
    private JTextField jtfBusNo = new JTextField();
    
    private JLabel jlblStaffID = new JLabel("     Staff ID:                 ");
    private JTextField jtfStaffID = new JTextField();
    
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public DeleteBusInfo1(String des){
        busMaintain = new MaintainBus();
        busInfo bus = busMaintain.getName(des);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblBusID);
        boxes1.add(jtfBusID);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblBusNo);
        boxes2.add(jtfBusNo);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblStaffID);
        boxes3.add(jtfStaffID);
        
        JPanel p1 = new JPanel(new GridLayout(7,1));
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder("Current Bus Information"));
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        add(p1);
        
        jtfBusID.setText(String.format("%s",bus.getbusID()));
        jtfBusID.setEditable(false);
        jtfBusNo.setText(String.format("%s",bus.getbusNo()));
        jtfBusNo.setEditable(false);
        jtfStaffID.setText(String.format("%s",bus.getStaffID()));
        jtfStaffID.setEditable(false);
        
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
        
        setTitle("Bus CRUD");
        setSize(1000,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        busInfo bus = busMaintain.selectRecord(jtfBusID.getText());

                int i = JOptionPane.showConfirmDialog(null, "Are you sure delete?","Record Delete",JOptionPane.YES_NO_OPTION);
            
            if (bus != null) {
              if(i==0){
                bus = new busInfo(jtfBusID.getText(),jtfBusNo.getText(), jtfStaffID.getText());
  
                busMaintain.deleteRecord(bus);
                
                JOptionPane.showMessageDialog(null, "Bus Deleted! ");
                setVisible(false);
                new DeleteBusInfo();
              }
            } else {
               JOptionPane.showMessageDialog(null, "Bus ID are not exist","Bus ID not found",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
 
    public static void main(String[] args) {
        new DeleteBusInfo1("B1004");
    }   
}