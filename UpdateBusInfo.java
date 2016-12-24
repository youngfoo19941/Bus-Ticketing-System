package ui;
import control.MaintainBus;
import domain.busInfo;
import da.BusInfoDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateBusInfo extends JFrame{

    private MaintainBus busMaintain = new MaintainBus();
    
    private JTextField jtfBusID = new JTextField();
    private JTextField jtfBusNo = new JTextField();
    private JTextField jtfStaffID = new JTextField();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    private String[] staff = busMaintain.getAllBusNo();  
    private JList list = new JList(staff);

    public UpdateBusInfo() {
        add(new JLabel("BUS MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtUpdate);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new Back());

        setTitle("Update Bus Information");
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
        new UpdateBusInfo1(staffName);
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
        new UpdateBusInfo();
    }
}