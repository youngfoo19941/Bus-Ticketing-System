package ui;
import control.MaintainStaff;
import da.StaffDA;
import domain.Staff;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteStaff1 extends JFrame{

    private MaintainStaff staffMaintain;
    private JLabel jlblID = new JLabel("     Staff ID:                        ");
    private JTextField jtfID = new JTextField(8);
    
    private JLabel jlblName = new JLabel("     Staff Name:                 ");
    private JTextField jtfName = new JTextField(30);
    
    private JLabel jlblIC = new JLabel("     Staff IC:                        ");
    private JTextField jtfIC = new JTextField();
    
    private JLabel jlblAddress = new JLabel("     Address:                      ");
    private JTextArea jtfAddress = new JTextArea(2,2);
    
    
    private JLabel jlblcontactNo = new JLabel("    Contact No:                  ");
    private JTextField jtfcontactNo = new JTextField();
    
    private JLabel jlblGender = new JLabel("     Gender:                        ");
    private JTextField jtfGender = new JTextField();
    
    private JLabel jlblPosition = new JLabel("    Position:                        ");
    private JTextField jtfPosition = new JTextField();
    
    private JLabel jlblPassword = new JLabel("    Password:                   ");
    private JTextField jtfPassword = new JTextField();
   
    
    private JLabel jlblAge = new JLabel("    Age:                               ");
    private JTextField jtfAge = new JTextField();
   
    private JLabel jlblEmail = new JLabel("    Email Address             ");
    private JTextField jtfEmail = new JTextField();
    
    
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    
    //private String[] staff = staffMaintain.getStaffName();
   // private JList list = new JList(staff);
  
    public DeleteStaff1(String name){
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
        p1.setBorder(new TitledBorder("Delete Staff Information"));
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
        
        setTitle("Staff CRUD");
        setSize(1000,600);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
      
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        Staff staff = staffMaintain.selectRecord(jtfID.getText());

                int i = JOptionPane.showConfirmDialog(null, "Are you sure delete?","Record Delete",JOptionPane.YES_NO_OPTION);
            
            if (staff != null) {
              if(i==0){
                staff = new Staff(jtfID.getText(),jtfName.getText(), jtfIC.getText(), jtfAddress.getText(), jtfPassword.getText(), jtfGender.getText(), jtfPosition.getText(),Integer.parseInt(jtfAge.getText()),jtfcontactNo.getText(),jtfEmail.getText());
  
                staffMaintain.deleteRecord(staff);
                
                JOptionPane.showMessageDialog(null, "Staff Deleted! ");
                setVisible(false);
                new DeleteStaff();
              }
            } else {
               JOptionPane.showMessageDialog(null, "Staff ID are not exist","Staff ID not found",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
 
     
     
    public static void main(String[] args) {
        new DeleteStaff1("adasd");
    }
    
}
