package ui;
import control.MaintainSchedule;
import domain.Schedule;
import da.ScheduleDA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class DeleteSchedule extends JFrame{

    private MaintainSchedule scheduleMaintain = new MaintainSchedule();
    
    //private JTextField jtfScheduleID = new JTextField();
    //private JTextField jtfDestination = new JTextField();
    //private JTextField jtfIC = new JTextField();
    private JButton jbtDelete = new JButton("Delete");
    private JButton jbtBack = new JButton("Back");
    private String[] destination = scheduleMaintain.getScheduleDestination();  
    private JList list = new JList(destination);

    public DeleteSchedule() {
        add(new JLabel("Schedule MENU"),BorderLayout.NORTH);
   
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(list);
        
        JPanel Add = new JPanel();
        Add.add(jbtDelete);
        Add.add(jbtBack);
        add(Add, BorderLayout.SOUTH);
        jbtDelete.addActionListener(new DeleteListener());
        jbtBack.addActionListener(new Back());

        setTitle("Schedule Delete");
        setUndecorated(true);
        setSize(700,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        String destination = String.format("%s",list.getSelectedValue());
        new DeleteSchedule1(destination);
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
        new DeleteSchedule();
    }
    


    
    
}
