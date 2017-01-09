package ui;
import domain.Staff;
import da.StaffDA;
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

public class AddStaff extends JFrame{
    private ButtonGroup group,group1;
    //ImageIcon a = new ImageIcon(getClass().getResource("/images/blur.jpg"));
    private MaintainStaff staffMaintain = new MaintainStaff();
    private JLabel jlblID = new JLabel("     Staff ID:                        ");
    private JTextField jtfID = new JTextField(10);
    private JLabel jlblName = new JLabel("     Staff Name:                 ");
    private JTextField jtfName = new JTextField();
    private JLabel jlblIC = new JLabel("     Staff IC:                        ");
    private JTextField jtfIC = new JTextField();
    private JLabel jlblAddress = new JLabel("     Address:                      ");
    private JTextArea jtfAddress = new JTextArea(2,2);
    
    
    private JLabel jlblcontactNo = new JLabel("    Contact No:                  ");
    private JTextField jtfcontactNo = new JTextField();
    private JLabel jlblGender = new JLabel("     Gender:                ");
    private JRadioButton jrbMale = new JRadioButton("Male");
    private JRadioButton jrbFemale = new JRadioButton("Female");
    
    private JLabel jlblPosition = new JLabel("    Position:               ");
    private JRadioButton jrbDriver = new JRadioButton("Driver");
    private JRadioButton jrbReceptionist = new JRadioButton("Receptionist");
    private JRadioButton jrbClerk = new JRadioButton("Clerk");
    private JRadioButton jrbManager = new JRadioButton("Manager");
    
    private JLabel jlblPassword = new JLabel("    Password:                   ");
    private JPasswordField jpfPassword = new JPasswordField();
    private JLabel jlblCPassword = new JLabel("    Confirm Password:   ");
    private JPasswordField jpfCPassword = new JPasswordField();
    private JLabel jlblAge = new JLabel("    Age:                               ");
    private JTextField jtfAge = new JTextField();
   
    private JLabel jlblEmail = new JLabel("    Email Address             ");
    private JTextField jtfEmail = new JTextField();
    
    

    private JButton jbtAdd = new JButton("Create");
    private JButton jbtCancel = new JButton("Cancel");
  
    public AddStaff(){
        
        //setContentPane(new JLabel(a));
        String staffid = staffMaintain.selectRecord1();
        String b = staffid.substring(3,6);
        int c = Integer.parseInt(b)+1;
        String staffID = "ASD"+String.format("%d", c);
        jtfID.setText(staffID);
        
        staffMaintain = new MaintainStaff();
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblID);
        boxes1.add(jtfID);
        jtfID.setEditable(false);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblName);
        boxes2.add(jtfName);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblIC);
        boxes3.add(jtfIC);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblAddress);
        boxes4.add(jtfAddress);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblcontactNo);
        boxes5.add(jtfcontactNo);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblGender);
        boxes6.add(jrbMale);
        boxes6.add(jrbFemale);
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblPosition);
        boxes7.add(jrbDriver);
        boxes7.add(jrbReceptionist);
        boxes7.add(jrbClerk);
        boxes7.add(jrbManager);
       
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblEmail);
        boxes8.add(jtfEmail);
        
        
        Box boxes10 = Box.createHorizontalBox();
        boxes10.add(jlblPassword);
        boxes10.add(jpfPassword);
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblCPassword);
        boxes11.add(jpfCPassword);
        
        Box boxes12 = Box.createHorizontalBox();
        boxes12.add(jlblAge);
        boxes12.add(jtfAge);
        
        JPanel p1 = new JPanel(new GridLayout(12,1));
        p1.setOpaque(false);
        p1.add(boxes1);
        p1.add(boxes2);
        p1.add(boxes3);
        p1.add(boxes10);
        p1.add(boxes11);
        p1.add(boxes6);
        p1.add(boxes12);
        p1.add(boxes4);
        p1.add(boxes5);
        p1.add(boxes7);
        p1.add(boxes8);
        
        setLayout(new BorderLayout());
        add(p1,BorderLayout.NORTH);
        
        JPanel LastPanel = new JPanel();
        LastPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        LastPanel.setOpaque(false);
        LastPanel.add(jbtAdd);
        LastPanel.add(jbtCancel);
        add(LastPanel);
        
        jrbMale.setOpaque(false); 
        jrbFemale.setOpaque(false);
        jrbDriver.setOpaque(false);
        jrbReceptionist.setOpaque(false);
        jrbClerk.setOpaque(false);
        jrbManager.setOpaque(false);
        
        group = new ButtonGroup();
  	group.add(jrbMale);
  	group.add(jrbFemale);
        
        group1 = new ButtonGroup();
  	group1.add(jrbClerk);
  	group1.add(jrbReceptionist);
        group1.add(jrbManager);
        group1.add(jrbDriver);
  	
        
        
        
        jbtAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        try{    
            Staff staff = staffMaintain.selectRecord(jtfID.getText());
            
            int Valid =1;
            
            if(!jpfPassword.getText().equals(jpfCPassword.getText())){
                    JOptionPane.showMessageDialog(null, "Password is not match");
                    Valid=0;
                    }
            if(!jtfName.getText().matches("[A-Z a-z]*")&&!jtfName.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Name can not enter number. e.g: Tey Choon Wei");
                Valid=0;
            }
            if(!jtfIC.getText().matches("[0-9]*") && !jtfIC.getText().isEmpty()&&jtfIC.getText().length()>12 || jtfIC.getText().length()<12){
                JOptionPane.showMessageDialog(null, "Ic must be 12 digits number. e.g:940117085483");
                Valid=0;
            }
           
             if(!jtfAge.getText().matches("[0-9]*")&&!jtfAge.getText().isEmpty()&&jtfIC.getText().length()>3||jtfIC.getText().length()<3){
                JOptionPane.showMessageDialog(null, "Age must be number. e.g: 12");
                Valid=0;
            }
             if(!jtfcontactNo.getText().matches("[0-9]*")&&!jtfcontactNo.getText().isEmpty()||jtfcontactNo.getText().length()!=10){
                JOptionPane.showMessageDialog(null, "Phone number format invalid. eg.0165389328");
                Valid=0;
            }
             
            
             if(!jtfEmail.getText().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")&&!jtfEmail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Email format Incorrect. eg. teycw17@hotmail.com");
                Valid=0;
            }
             String jtfPosition="", jtfGender="";
                if(!jrbDriver.isSelected()&&!jrbReceptionist.isSelected()&&!jrbClerk.isSelected()&&!jrbManager.isSelected()&&!jrbMale.isSelected()&&!jrbFemale.isSelected()){
                     JOptionPane.showMessageDialog(null, "Plese fill up all information");
                     Valid=0;
                }
                if(!jrbDriver.isSelected()&&!jrbReceptionist.isSelected()&&!jrbClerk.isSelected()&&!jrbManager.isSelected()){
                     JOptionPane.showMessageDialog(null, "Plese fill up all information");
                     Valid=0;
                }
                
                if(Valid==0){
                    
                }

            
            else{
                
                //String jtfPosition="", jtfGender="";
                if(jrbDriver.isSelected()){
                     jtfPosition = jrbDriver.getText();
                }
                if(jrbReceptionist.isSelected()){
                     jtfPosition = jrbReceptionist.getText();
                }
                if(jrbClerk.isSelected()){
                     jtfPosition = jrbClerk.getText();
                }
                if(jrbManager.isSelected()){
                     jtfPosition = jrbManager.getText();
                }
                if(jrbMale.isSelected()){
                    jtfGender = jrbMale.getText();
                }
                if(jrbFemale.isSelected()){
                    jtfGender = jrbFemale.getText();
                }
                
                
                
                int yes=1;
                
                yes = JOptionPane.showConfirmDialog(null, "Are you sure to add?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if(yes==JOptionPane.YES_OPTION){
                    
                  
                    staff = new Staff(jtfID.getText(),jtfName.getText(), jtfIC.getText(), jtfAddress.getText(), jpfPassword.getText(), jtfGender, jtfPosition,Integer.parseInt(jtfAge.getText()),jtfcontactNo.getText(),jtfEmail.getText());
                    staffMaintain.addRecord(staff);

                    JOptionPane.showMessageDialog(null, "Staff Added");
                    setVisible(false);
                }
                
             }
                
            
                 
            
        }catch(NumberFormatException ex){
            
            if(jtfIC.getText().equals("")||jtfName.getText().equals("")||!jtfIC.getText().equals("")||jtfAge.getText().equals("")||jtfcontactNo.getText().equals("")||jtfEmail.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill up all Staff Information !", "Invalid Add", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        }});
        
       
        
        jbtCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        
        

        setTitle("Add New Staff");
        //setUndecorated(true);
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    
    
    public static void main(String[] args) {
        new AddStaff();
    }
    
}
