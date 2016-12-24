package ui;
import control.MaintainBus;
import da.BusInfoDA;
import domain.busInfo;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import domain.Staff;
import control.MaintainStaff;

public class UpdateBusInfo1 extends JFrame{

    private MaintainStaff staffMaintain;
    private MaintainBus busMaintain;
    private JLabel jlblBusID = new JLabel("       Bus ID:                  ");
    private JTextField jtfBusID = new JTextField(8);
    private JLabel jlblBusID2 = new JLabel("       Bus ID:                  ");
    private JTextField jtfBusID2 = new JTextField(8);
    
    private JLabel jlblBusNo = new JLabel("       Bus No:                 ");
    private JTextField jtfBusNo = new JTextField(30);
    private JLabel jlblBusNo2 = new JLabel("       Bus No:                 ");
    private JTextField jtfBusNo2 = new JTextField(30);
    
    private JLabel jlblStaffID = new JLabel("       Staff ID:                 ");
    private JTextField jtfStaffID = new JTextField(30);
    private JLabel jlblStaffID2 = new JLabel("       Staff ID:                 ");
    //private JTextField jtfStaffID2 = new JTextField(30);
    
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public UpdateBusInfo1(String name){
        staffMaintain = new MaintainStaff();
        staffMaintain = new MaintainStaff();
        String[] staff = staffMaintain.getid();
        JComboBox a = new JComboBox(staff);
        
        busMaintain = new MaintainBus();
        busInfo bus = busMaintain.getName(name);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblBusID);
        boxes1.add(jtfBusID);
        add(boxes1);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblBusNo);
        boxes2.add(jtfBusNo);
        add(boxes2);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblStaffID);
        boxes3.add(jtfStaffID);
        add(boxes3);
        
        JPanel p1 = new JPanel(new GridLayout(6,1));
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder("Current Bus Information"));
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        add(p1);
        
        jtfBusID.setText(String.format("%s",bus.getbusID()));
        jtfBusID.setEditable(false);
        jtfBusID2.setText(String.format("%s",bus.getbusID()));
        jtfBusID2.setEditable(false);
        jtfBusNo.setText(String.format("%s",bus.getbusNo()));
        jtfBusNo.setEditable(false);
        jtfStaffID.setText(String.format("%s",bus.getStaffID()));
        jtfStaffID.setEditable(false);
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblBusID2);
        boxes11.add(jtfBusID2);
        
        Box boxes12 = Box.createHorizontalBox();
        boxes12.add(jlblBusNo2);
        boxes12.add(jtfBusNo2);
        
        Box boxes13 = Box.createHorizontalBox();
        boxes13.add(jlblStaffID2);
        boxes13.add(a);
   
        JPanel p2 = new JPanel(new GridLayout(6,1));
        p2.setOpaque(false);
        p2.setBorder(new TitledBorder("Current Bus Information"));
        p2.add(boxes11);
        p2.add(boxes12);
        p2.add(boxes13);
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
        jbtUpdate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String jtfstaffID2="";
                for(int i=0; i<31 ;i++){
                    if(a.getSelectedIndex()== i){
                           jtfstaffID2 += staff[i];
                    }
                }
                int Valid;
            Valid =1;
        busInfo bus = busMaintain.selectRecord(jtfBusID.getText());
            if(jtfBusNo2.getText().equals("")){
                jtfBusNo2.setText(jtfBusNo.getText());
            }
            /*if(jtfStaffID2.getText().equals("")){
                jtfStaffID2.setText(jtfStaffID.getText());
            }*/
            if(!jtfBusNo2.getText().matches("[A-Z]+[0-9]+")){
                JOptionPane.showMessageDialog(null, "Bus No format invalid. eg.AHR127");
                Valid=0;
            }
            if(Valid==0){
                
            }
            
            else{
                
                     int yes = JOptionPane.showConfirmDialog(null,"Sure to exchange bus information?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(yes==JOptionPane.YES_OPTION){
                 
             bus = new busInfo(jtfBusID2.getText(),jtfBusNo2.getText(),jtfstaffID2);
                
              busMaintain.updateRecord(bus);
                 
              JOptionPane.showMessageDialog(null, "New Bus Updated !");
            }
            }
            }
        });
        jbtReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jtfBusNo2.setText("");
            }
        });
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UpdateSchedule();
                setVisible(false);
            }
        });
        
        setTitle("Update Bus Information");
        setSize(850,400);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    /*private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int Valid;
            Valid =1;
        busInfo bus = busMaintain.selectRecord(jtfBusID.getText());
            if(jtfBusNo2.getText().equals("")){
                jtfBusNo2.setText(jtfBusNo.getText());
            }
            if(jtfStaffID2.getText().equals("")){
                jtfStaffID2.setText(jtfStaffID.getText());
            }
            if(!jtfBusNo.getText().matches("[A-Z]+[0-9]+")){
                JOptionPane.showMessageDialog(null, "Bus No format invalid. eg.AHR127");
            }
            
            
            else{
                String jtfstaffID="";
                for(int i=0; i<31 ;i++){
                    if(a.getSelectedIndex()== i){
                           jtfstaffID += staff[i];
                    }
                }
                     int yes = JOptionPane.showConfirmDialog(null,"Sure to exchange bus information?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(yes==JOptionPane.YES_OPTION){
                 
             bus = new busInfo(jtfBusID2.getText(),jtfBusNo2.getText(),jtfStaffID2.getText());
                
              busMaintain.updateRecord(bus);
                 
              JOptionPane.showMessageDialog(null, "New Bus Updated !");
            }
            }
            
        }
    }*/
 
    public static void main(String[] args) {
        new UpdateBusInfo1("AHR824");
    }   
}