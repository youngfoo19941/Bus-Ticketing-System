package ui;
import control.MaintainStaff;
import domain.Staff;
import da.StaffDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateStaff extends JFrame{

    private MaintainStaff staffMaintain = new MaintainStaff();
    
    //private JTextField jtfStaffID = new JTextField();
    //private JTextField jtfStaffName = new JTextField();
    //private JTextField jtfIC = new JTextField();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    private String[] staff = staffMaintain.getStaffName();  
    private JList list = new JList(staff);

    public UpdateStaff() {
        add(new JLabel("STAFF MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtUpdate);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new Back());

        setTitle("Staff Update");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String staffName = String.format("%s",list.getSelectedValue());
        new UpdateStaff1(staffName);
        setVisible(false);
        }
    }
    
    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateStaff();
    }
    
}
