package ui;
import control.MaintainBus;
import domain.busInfo;
import da.BusInfoDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteBusInfo extends JFrame{

    private MaintainBus busMaintain = new MaintainBus();
    
    //private JTextField jtfScheduleID = new JTextField();
    //private JTextField jtfDestination = new JTextField();
    //private JTextField jtfIC = new JTextField();
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    private String[] destination = busMaintain.getAllBusNo();  
    private JList list = new JList(destination);

    public DeleteBusInfo() {
        add(new JLabel("BUS MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtDelete);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtDelete.addActionListener(new DeleteListener());
        jbtBack.addActionListener(new Back());

        setTitle("Delete Bus Information");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String destination1 = String.format("%s",list.getSelectedValue());
        new DeleteBusInfo1(destination1);
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
        new DeleteBusInfo();
    }   
}