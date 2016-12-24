package ui;
import control.MaintainSchedule;
import domain.Schedule;
import da.ScheduleDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UpdateSchedule extends JFrame{

    private MaintainSchedule scheduleMaintain = new MaintainSchedule();
    
    //private JTextField jtfScheduleID = new JTextField();
    //private JTextField jtfDestination = new JTextField();
    //private JTextField jtfIC = new JTextField();
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtBack = new JButton("Back");
    private String[] destination = scheduleMaintain.getScheduleDestination();  
    private JList list = new JList(destination);

    public UpdateSchedule() {
        add(new JLabel("Schedule MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtUpdate);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtUpdate.addActionListener(new UpdateListener());
        jbtBack.addActionListener(new Back());

        setTitle("Schedule Update");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String destination = String.format("%s",list.getSelectedValue());
        new UpdateSchedule1(destination);
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
        new UpdateSchedule();
    }
    
}
