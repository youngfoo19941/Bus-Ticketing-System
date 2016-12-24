package ui;
import control.MaintainStaff;
import domain.Staff;
import da.StaffDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteStaff extends JFrame{

    private MaintainStaff staffMaintain = new MaintainStaff();
    
    private JTextField jtfStaffID = new JTextField();
    private JTextField jtfStaffName = new JTextField();
    private JTextField jtfIC = new JTextField();
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    private String[] staff = staffMaintain.getStaffName();  
    private JList list = new JList(staff);

    public DeleteStaff() {
        add(new JLabel("STAFF MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtDelete);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtDelete.addActionListener(new DeleteListener());
        jbtBack.addActionListener(new Back());

        setTitle("Staff Delete");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String staffName = String.format("%s",list.getSelectedValue());
        new DeleteStaff1(staffName);
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
        new DeleteStaff();
    }
    
}
