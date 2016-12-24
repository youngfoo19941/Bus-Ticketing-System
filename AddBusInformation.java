package ui;
import domain.busInfo;
import da.BusInfoDA;
import control.MaintainBus;
import domain.Staff;
import control.MaintainStaff;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.lang.ArrayIndexOutOfBoundsException;
//import java.util.ArrayList;

public class AddBusInformation extends JFrame{
    
    private MaintainBus busMaintain = new MaintainBus();
    private MaintainStaff staffMaintain;
    private JLabel jlblbusID = new JLabel("        Bus ID:             ");
    private JTextField jtfbusID = new JTextField(10);
    private JLabel jlblbusNo = new JLabel("        Bus Number:  ");
    private JTextField jtfbusNo = new JTextField();
    private JLabel jlblstaffID = new JLabel("        Staff ID:            ");
    //private JTextField jtfstaffID = new JTextField();
    private JLabel jlblstaffName = new JLabel("        Staff Name:  ");
    private JTextField jtfstaffName = new JTextField();
    
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtCancel = new JButton("Cancel");
    
    public AddBusInformation(){
        String Busid = busMaintain.selectRecord1();
        String b1 = Busid.substring(1,5);
        int c = Integer.parseInt(b1)+1;
        String busID = "B"+String.format("%d", c);
        jtfbusID.setText(busID);
        jtfbusID.setEditable(false);
        
        
        staffMaintain = new MaintainStaff();
        String[] staff = staffMaintain.getid();
        JComboBox a = new JComboBox(staff);
        
        busMaintain = new MaintainBus();
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblbusID);
        boxes1.add(jtfbusID);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblbusNo);
        boxes2.add(jtfbusNo);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblstaffID);
        boxes3.add(a);
        
        
        
        JPanel p1 = new JPanel(new GridLayout(4,1));
        p1.setOpaque(false);
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtAdd);
        LastPanel.add(jbtCancel);
        add(LastPanel);
        
        jbtAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            
            busInfo bus = busMaintain.selectRecord(jtfbusID.getText());
            
            
            int Valid;
            Valid=1;
            if(jtfbusNo.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill up all Bus Information !");
                Valid=0;
            }
            if(!jtfbusNo.getText().matches("[A-Z a-z]+.[0-9]+")&&!jtfbusNo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Bus No format invalid. eg.ASD123");
                Valid=0;
            }
            if(Valid==0){
                
            }
            else{
                String jtfstaffID="";
                for(int i=0; i<31 ;i++){
                    if(a.getSelectedIndex()== i){
                           jtfstaffID += staff[i];
                    }
                }
                
                int yes=1;
                
                yes = JOptionPane.showConfirmDialog(null, "Are you sure to add?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(yes==JOptionPane.YES_OPTION){
                    
                  
                    bus = new busInfo(jtfbusID.getText(),jtfbusNo.getText(), jtfstaffID);
                    busMaintain.addRecord(bus);

                    JOptionPane.showMessageDialog(null, "Bus Added");
                    setVisible(false);
                }
                
            }
 
        
        }});
        
        jbtCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
        });
        
        setTitle("Add New Bus");
        setSize(275,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }
    
    public static void main(String[] args) {
        new AddBusInformation();
    }   
}