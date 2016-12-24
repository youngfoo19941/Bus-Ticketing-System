package ui;
import control.MaintainStaff;
import da.StaffDA;
import domain.Staff;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStaff1 extends JFrame{

    private MaintainStaff staffMaintain;
    private JLabel jlblID = new JLabel("     Staff ID:                        ");
    private JTextField jtfID = new JTextField(8);
    private JLabel jlblID2 = new JLabel("     Staff ID:                        ");
    private JTextField jtfID2 = new JTextField(8);
    
    private JLabel jlblName = new JLabel("     Staff Name:                 ");
    private JTextField jtfName = new JTextField(30);
    private JLabel jlblName2 = new JLabel("     Staff Name:                 ");
    private JTextField jtfName2 = new JTextField(30);
    
    private JLabel jlblIC = new JLabel("     Staff IC:                        ");
    private JTextField jtfIC = new JTextField();
    private JLabel jlblIC2 = new JLabel("     Staff IC:                        ");
    private JTextField jtfIC2 = new JTextField();
    
    private JLabel jlblAddress = new JLabel("     Address:                      ");
    private JTextArea jtfAddress = new JTextArea(2,2);
    private JLabel jlblAddress2 = new JLabel("     Address:                      ");
    private JTextArea jtfAddress2 = new JTextArea(2,2);
    
    
    private JLabel jlblcontactNo = new JLabel("    Contact No:                  ");
    private JTextField jtfcontactNo = new JTextField();
    private JLabel jlblcontactNo2 = new JLabel("    Contact No:                  ");
    private JTextField jtfcontactNo2 = new JTextField();
    
    private JLabel jlblGender = new JLabel("     Gender:                        ");
    private JTextField jtfGender = new JTextField();
    private JLabel jlblGender2 = new JLabel("     Gender:                        ");
    private JTextField jtfGender2 = new JTextField();
    
    private JLabel jlblPosition = new JLabel("    Position:                        ");
    private JTextField jtfPosition = new JTextField();
    private JLabel jlblPosition2 = new JLabel("    Position:                        ");
    private JTextField jtfPosition2 = new JTextField();
    
    private JLabel jlblPassword = new JLabel("    Password:                   ");
    private JTextField jtfPassword = new JTextField();
    private JLabel jlblPassword2 = new JLabel("    Password:                   ");
    private JPasswordField jpfPassword2 = new JPasswordField();
   
    private JLabel jlblCPassword2 = new JLabel("    Confirm Password:   ");
    private JPasswordField jpfCPassword2 = new JPasswordField();
    
    private JLabel jlblAge = new JLabel("    Age:                               ");
    private JTextField jtfAge = new JTextField();
    private JLabel jlblAge2 = new JLabel("    Age:                               ");
    private JTextField jtfAge2 = new JTextField();
   
    private JLabel jlblEmail = new JLabel("    Email Address             ");
    private JTextField jtfEmail = new JTextField();
    private JLabel jlblEmail2 = new JLabel("    Email Address             ");
    private JTextField jtfEmail2 = new JTextField();
    
    
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtReset = new JButton("Reset");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public UpdateStaff1(String name){
        staffMaintain = new MaintainStaff();
        Staff staff = staffMaintain.getName(name);
        Box boxes1 = Box.createHorizontalBox();
        boxes1.add(jlblID);
        boxes1.add(jtfID);
        add(boxes1);
        
        Box boxes2 = Box.createHorizontalBox();
        boxes2.add(jlblName);
        boxes2.add(jtfName);
        add(boxes2);
        
        Box boxes3 = Box.createHorizontalBox();
        boxes3.add(jlblIC);
        boxes3.add(jtfIC);
        add(boxes3);
        
        Box boxes4 = Box.createHorizontalBox();
        boxes4.add(jlblPassword);
        boxes4.add(jtfPassword);
        add(boxes4);
        
        Box boxes5 = Box.createHorizontalBox();
        boxes5.add(jlblGender);
        boxes5.add(jtfGender);
        add(boxes5);
        
        Box boxes6 = Box.createHorizontalBox();
        boxes6.add(jlblAge);
        boxes6.add(jtfAge);
        add(boxes6);
        
        Box boxes7 = Box.createHorizontalBox();
        boxes7.add(jlblAddress);
        boxes7.add(jtfAddress);
        add(boxes7);
        
        Box boxes8 = Box.createHorizontalBox();
        boxes8.add(jlblcontactNo);
        boxes8.add(jtfcontactNo);
        add(boxes8);
        
        Box boxes9 = Box.createHorizontalBox();
        boxes9.add(jlblPosition);
        boxes9.add(jtfPosition);
        add(boxes9);
                
        Box boxes10 = Box.createHorizontalBox();
        boxes10.add(jlblEmail);
        boxes10.add(jtfEmail);
        add(boxes10);
        
        
        
        
        
        JPanel p1 = new JPanel(new GridLayout(10,1));
        p1.setOpaque(false);
        p1.setBorder(new TitledBorder("Current Staff Information"));
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
        add(p1);
        
        jtfID.setText(String.format("%s",staff.getID()));
        jtfID.setEditable(false);
        jtfID2.setText(String.format("%s",staff.getID()));
        jtfID2.setEditable(false);
        jtfName.setText(String.format("%s",staff.getName()));
        jtfName.setEditable(false);
        jtfIC.setText(String.format("%s",staff.getIC()));
        jtfIC.setEditable(false);
        jtfPassword.setText(String.format("%s",staff.getPassword()));
        jtfPassword.setEditable(false);
        jtfGender.setText(String.format("%s",staff.getGender()));
        jtfGender.setEditable(false);
        jtfAge.setText(String.format("%s",staff.getAge()));
        jtfAge.setEditable(false);
        jtfAddress.setText(String.format("%s",staff.getAddress()));
        jtfAddress.setEditable(false);
        jtfcontactNo.setText(String.format("%s",staff.getcontactNo()));
        jtfcontactNo.setEditable(false);
        jtfPosition.setText(String.format("%s",staff.getPosition()));
        jtfPosition.setEditable(false);
        jtfEmail.setText(String.format("%s",staff.getEmail()));
        jtfEmail.setEditable(false);
        
        
        Box boxes11 = Box.createHorizontalBox();
        boxes11.add(jlblID2);
        boxes11.add(jtfID2);
        
        Box boxes12 = Box.createHorizontalBox();
        boxes12.add(jlblName2);
        boxes12.add(jtfName2);
        
        
        Box boxes13 = Box.createHorizontalBox();
        boxes13.add(jlblIC2);
        boxes13.add(jtfIC2);
        
        Box boxes14 = Box.createHorizontalBox();
        boxes14.add(jlblPassword2);
        boxes14.add(jpfPassword2);
        
        Box boxes15 = Box.createHorizontalBox();
        boxes15.add(jlblCPassword2);
        boxes15.add(jpfCPassword2);
        
        Box boxes16 = Box.createHorizontalBox();
        boxes16.add(jlblGender2);
        boxes16.add(jtfGender2);
        
        
        Box boxes17 = Box.createHorizontalBox();
        boxes17.add(jlblAge2);
        boxes17.add(jtfAge2);
        
        Box boxes18 = Box.createHorizontalBox();
        boxes18.add(jlblAddress2);
        boxes18.add(jtfAddress2);
        
        Box boxes19 = Box.createHorizontalBox();
        boxes19.add(jlblcontactNo2);
        boxes19.add(jtfcontactNo2);
    
        Box boxes20 = Box.createHorizontalBox();
        boxes20.add(jlblPosition2);
        boxes20.add(jtfPosition2);
        
       
        Box boxes21 = Box.createHorizontalBox();
        boxes21.add(jlblEmail2);
        boxes21.add(jtfEmail2);
        
   
        JPanel p2 = new JPanel(new GridLayout(11,1));
        p2.setOpaque(false);
        p2.setBorder(new TitledBorder("Current Staff Information"));
        p2.add(boxes11);
        p2.add(boxes12);
        p2.add(boxes13);
        p2.add(boxes14);
        p2.add(boxes15);
        p2.add(boxes16);
        p2.add(boxes17);
        p2.add(boxes18);
        p2.add(boxes19);
        p2.add(boxes20);
        p2.add(boxes21);
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
        
        jbtUpdate.addActionListener(new UpdateListener());
        jbtReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jtfName2.setText("");
                jtfGender2.setText("");
                jtfIC2.setText("");
                jpfPassword2.setText("");
                jpfCPassword2.setText("");
                jtfAge2.setText("");
                jtfAddress2.setText("");
                jtfcontactNo2.setText("");
                jtfPosition2.setText("");
                jtfEmail2.setText("");
            }
            });
        jbtBack.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
            }
            });
        
        setTitle("Staff CRUD");
        setSize(1000,600);
        //setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int validationFlag;
        Staff staff = staffMaintain.selectRecord(jtfID.getText());
        
        validationFlag=1;
            if(jtfName2.getText().equals("")){
                jtfName2.setText(jtfName.getText());
            }
            if(jtfGender2.getText().equals("")){
                jtfGender2.setText(jtfGender.getText());
            }
            if(jtfPosition2.getText().equals("")){
                jtfPosition2.setText(jtfPosition.getText());
            }
            if(jtfIC2.getText().equals("")){
                jtfIC2.setText(String.valueOf(jtfIC.getText()));
            }
            if(jpfPassword2.getText().equals("")){
                jpfPassword2.setText(String.format("%s",jtfPassword.getText()));
            }
            if(jpfCPassword2.getText().equals("")){
                jpfCPassword2.setText(String.format("%s",jtfPassword.getText()));
            }
            if(jtfAge2.getText().equals("")){
                jtfAge2.setText(String.valueOf(jtfAge.getText()));
            }
            if(jtfAddress2.getText().equals("")){
                jtfAddress2.setText(String.format("%s",jtfAddress.getText()));
            }
            if(jtfcontactNo2.getText().equals("")){
                jtfcontactNo2.setText(String.valueOf(jtfcontactNo.getText()));
            }
            if(jtfEmail2.getText().equals("")){
                jtfEmail2.setText(String.format("%s", jtfEmail.getText()));
            }
            
            if(!jpfPassword2.getText().equals(jpfCPassword2.getText())){
                    JOptionPane.showMessageDialog(null, "Password is not match");
                    validationFlag=0;
                    }

            if(!jtfName2.getText().matches("[A-Z a-z]*")){
                JOptionPane.showMessageDialog(null, "Name can not enter number. e.g: Tey Choon Wei");
                validationFlag=0;
            }
 
            if(!jtfIC2.getText().matches("[0-9]*") || jtfIC2.getText().length()!=12){
                JOptionPane.showMessageDialog(null, "Ic must be 12 digits number. e.g:940117085483");
                validationFlag=0;
            }

             if(!jtfAge2.getText().matches("[0-9]*")){
                JOptionPane.showMessageDialog(null, "Age must be number. e.g: 12");
                validationFlag=0;
            }

             if(!jtfcontactNo2.getText().matches("[0-9]*")||jtfcontactNo2.getText().length()!=10){
                JOptionPane.showMessageDialog(null, "Phone number 10 digit-number.");
                validationFlag=0;
                
            }

             if(!jtfEmail2.getText().matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")){
                JOptionPane.showMessageDialog(null, "Email format Incorrect. eg.teycw17@hotmail.com");
                validationFlag=0;
            }

            if(!jtfGender2.getText().equals("Male")&&!jtfGender2.getText().equals("Female")){
                JOptionPane.showMessageDialog(null, "Gender just can type in: \ni.Male\nii.Female \ne.g Male");
                validationFlag=0;
                
            }
            if(!jtfPosition2.getText().equals("Clerk")&&!jtfPosition2.getText().equals("Receptionist")&&!jtfPosition2.getText().equals("Driver")&&!jtfPosition2.getText().equals("Manager")){
                JOptionPane.showMessageDialog(null, "Position  just can type in: \ni.Clerk\nii.Receptionist\niii.Driver\niv.Manager \ne.g Clerk");
                validationFlag=0;
                
            }

        
            
        
            
            
            if(validationFlag==0){
                
            }  
                
            else{ 
            String ic = "";
            ic=(jtfIC2.getText());
            
                     int yes = JOptionPane.showConfirmDialog(null,"Sure to Update staff information?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
             if(yes==JOptionPane.YES_OPTION){
                 
             staff = new Staff(jtfID2.getText(),jtfName2.getText(), ic, jtfAddress2.getText(), jpfPassword2.getText(), jtfGender2.getText(), jtfPosition2.getText(),Integer.parseInt(jtfAge2.getText()),jtfcontactNo2.getText(),jtfEmail2.getText());
                
              staffMaintain.updateRecord(staff);
                 
              JOptionPane.showMessageDialog(null, "New Staff Updated !");
             }
             
             
           
                
               
           
            }
        }
    }
 
     
     
    public static void main(String[] args) {
        new UpdateStaff1("adasd");
    }
    
}
