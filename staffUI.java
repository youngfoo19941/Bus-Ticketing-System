package ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Toolkit;
import domain.*;
import da.StaffDA;
import domain.Staff;
import control.MaintainStaff;

public class staffUI extends JFrame{ 
    private JMenuItem jmiManageBus,jmiManageSchedule,jmiStaff,jmiTicket,jmiReport,jmiInsurance,jmiStaffHelp,jmiTicketHelp,jmiBusHelp,jmiDriverHelp,jmiInsuranceHelp;
 
    
    ImageIcon a = new ImageIcon(getClass().getResource("/images/Background_1.jpg"));
    
    ImageIcon b = new ImageIcon(getClass().getResource("/images/Back.png"));
    private JButton Back = new JButton(b);
    ImageIcon c = new ImageIcon(getClass().getResource("/images/Back1.png"));
    private JButton back = new JButton(c);
    
    ImageIcon q = new ImageIcon(getClass().getResource("/images/exit1.png"));
    private JButton Quit = new JButton(q);
    ImageIcon q2 = new ImageIcon(getClass().getResource("/images/exit.png"));
    private JButton Quit1 = new JButton(q2);
    
    ImageIcon aStaff = new ImageIcon(getClass().getResource("/images/Staff Create Icon_1.fw.png"));
    private JButton jbtAdd = new JButton(aStaff);
    ImageIcon aStaff1 = new ImageIcon(getClass().getResource("/images/Staff Create Icon.fw.png"));
    private JButton jbtAdd1 = new JButton(aStaff1);
    
    ImageIcon rStaff = new ImageIcon(getClass().getResource("/images/Staff Retrieve Icon_1.fw.png"));
    private JButton jbtRetrieve = new JButton(rStaff);
    ImageIcon rStaff1 = new ImageIcon(getClass().getResource("/images/Staff Retrieve Icon.fw.png"));
    private JButton jbtRetrieve1 = new JButton(rStaff1);
    
    ImageIcon uStaff = new ImageIcon(getClass().getResource("/images/Staff Update Icon_1.fw.png"));
    private JButton jbtUpdate = new JButton(uStaff);
    ImageIcon uStaff1 = new ImageIcon(getClass().getResource("/images/Staff Update Icon.fw.png"));
    private JButton jbtUpdate1 = new JButton(uStaff1);
    
    ImageIcon dStaff = new ImageIcon(getClass().getResource("/images/Staff Delete Icon_1.fw.png"));
    private JButton jbtDelete = new JButton(dStaff);
    ImageIcon dStaff1 = new ImageIcon(getClass().getResource("/images/Staff Delete Icon.fw.png"));
    private JButton jbtDelete1 = new JButton(dStaff1);    
    Staff staff = new Staff();
public staffUI(Staff staff) {
    this.staff = staff;
        JMenuBar jmb = new JMenuBar();
        setJMenuBar(jmb);
        
        JMenu staffMenu = new JMenu("Staff");
        staffMenu.setMnemonic('S');
        staffMenu.add(jmiStaff = new JMenuItem("1.Manage Staff",'1'));
        jmb.add(staffMenu);
        
        
        JMenu ticketMenu = new JMenu("Ticket");
        ticketMenu.setMnemonic('T');
        ticketMenu.add(jmiTicket = new JMenuItem("1.Manage Ticket",'1'));
        jmb.add(ticketMenu);
        
        JMenu Bus = new JMenu("Bus");
        Bus.setMnemonic('B');
        jmb.add(Bus);
        Bus.add(jmiManageBus = new JMenuItem("1.Bus Infomation",'1'));
        Bus.add(jmiManageSchedule = new JMenuItem("2.Bus Schedule",'2'));
        
        JMenu Insurance = new JMenu("Insurance");
        Insurance.setMnemonic('I');
        jmb.add(Insurance);
        Insurance.add(jmiInsurance = new JMenuItem("1.Manage Insurance",'1'));
        
        JMenu report = new JMenu("Report");
        jmb.add(report);
        report.setMnemonic('R');
        report.add(jmiReport = new JMenuItem("1.Report Information",'1'));
        
        JMenu help = new JMenu("Help");
        help.setMnemonic('H');
        jmb.add(help);
        help.add(jmiStaffHelp = new JMenuItem("1.Staff Help",'1'));
        help.add(jmiTicketHelp = new JMenuItem("2.Ticket Help",'2'));
        help.add(jmiBusHelp = new JMenuItem("3.Bus Help",'3'));
        help.add(jmiDriverHelp = new JMenuItem("4.Driver Schedule Help",'4'));
        help.add(jmiInsuranceHelp = new JMenuItem("5.Insurance Help",'5'));
        
        
        jmiManageBus.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiManageSchedule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
        jmiStaff.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiInsurance.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiTicket.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiStaffHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,ActionEvent.CTRL_MASK));
        jmiTicketHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,ActionEvent.CTRL_MASK));
        jmiBusHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,ActionEvent.CTRL_MASK));
        jmiDriverHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,ActionEvent.CTRL_MASK));
        jmiInsuranceHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,ActionEvent.CTRL_MASK));
        if(staff.getPosition().equals("Driver")){
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }
        if(staff.getPosition().equals("Receptionist")){
            
            jmiStaff.setEnabled(false);
            jmiManageBus.setEnabled(false);
            jmiManageSchedule.setEnabled(false);
            jmiReport.setEnabled(false);
            jmiInsurance.setEnabled(false);
            
            
        }
        if(staff.getPosition().equals("Clerk")){
            
            jmiTicket.setEnabled(false);
            jmiReport.setEnabled(false);
            
        }
    
    setTitle("Staff Page");
    setContentPane(new JLabel(a));
    setLayout(new FlowLayout());
    
        JPanel p2 = new JPanel(new GridLayout(1,9)); 
        p2.setOpaque(false);
        p2.add(Back);
       
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(new JLabel(""));
        p2.add(Quit);
        
        Back.setContentAreaFilled(false);
        Back.setRolloverIcon(c);
        Back.setBorder(null);
       
        Quit.setContentAreaFilled(false);
        Quit.setRolloverIcon(q2);
        Quit.setBorder(null);
        
        jbtAdd.setContentAreaFilled(false);
        jbtAdd.setRolloverIcon(aStaff1);
        jbtAdd.setBorder(null);
        
        jbtRetrieve.setContentAreaFilled(false);
        jbtRetrieve.setRolloverIcon(rStaff1);
        jbtRetrieve.setBorder(null);
        
        jbtUpdate.setContentAreaFilled(false);
        jbtUpdate.setRolloverIcon(uStaff1);
        jbtUpdate.setBorder(null);
        
        jbtDelete.setContentAreaFilled(false);
        jbtDelete.setRolloverIcon(dStaff1);
        jbtDelete.setBorder(null);
        add(p2, BorderLayout.NORTH);
    
        JPanel p1 = new JPanel(new GridLayout(1,4));
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(FlowLayout.LEFT,40,180));
        p1.add(jbtAdd);
        p1.add(jbtRetrieve);
        p1.add(jbtUpdate);
        p1.add(jbtDelete); 
        add(p1,BorderLayout.NORTH);
        
        jbtAdd.setContentAreaFilled(false);
        //jbtAdd.setRolloverIcon(s);    //another images
        jbtAdd.setBorder(null);
        
        jbtRetrieve.setContentAreaFilled(false);
        //jbtRetrieve.setRolloverIcon(r);
        jbtRetrieve.setBorder(null);
        
        jbtUpdate.setContentAreaFilled(false);
        //jbtUpdate.setRolloverIcon(u);
        jbtUpdate.setBorder(null);
        
        jbtDelete.setContentAreaFilled(false);
        //jbtDelete.setRolloverIcon(d);
        jbtDelete.setBorder(null);
        
        jbtAdd.addActionListener(new addStaff());
        jbtRetrieve.addActionListener(new retrieveStaff());
        jbtUpdate.addActionListener(new updateStaff());
        jbtDelete.addActionListener(new deleteStaff());
        Back.addActionListener(new back());
        Quit.addActionListener(new quit());
        
        jmiManageBus.addActionListener(new busInfoMenu());
         jmiManageSchedule.addActionListener(new busScheduleMenu());
         jmiStaff.addActionListener(new staffMenu());
         jmiInsurance.addActionListener(new insuranceMenu());
         jmiTicket.addActionListener(new ticketMenu());
         jmiReport.addActionListener(new reportMenu());
         
         jmiStaffHelp.addActionListener(new sHelp());
         jmiTicketHelp.addActionListener(new tHelp());
         jmiBusHelp.addActionListener(new bHelp());
         jmiDriverHelp.addActionListener(new dHelp());
         jmiInsuranceHelp.addActionListener(new iHelp());
        

        setSize(1400,950);
        setLocationRelativeTo(null);
        
        setVisible(true);
        
}

private class addStaff implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new AddStaff();
        
    }
}

private class retrieveStaff implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new RetrieveStaff();
    }
}

private class updateStaff implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new UpdateStaff();
    }
}

private class deleteStaff implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        new DeleteStaff();
    }
}

private class staffMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new staffUI(staff);
            setVisible(false);
        }
    }
    
    
    private class ticketMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new TicketUI(staff);
            setVisible(false);
        }
    }
    

    private class reportMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new ReportUI(staff);
            setVisible(false);
        }
    }
    
    private class insuranceMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new InsuranceUI(staff);
            setVisible(false);
        }
    }
    
    private class busScheduleMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusScheduleUI(staff);
            setVisible(false);
        }
    }
    
    private class busInfoMenu implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new BusInformationUI(staff);
            setVisible(false);
        }
    }
    
    private class bHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           JOptionPane.showMessageDialog(null, "1.	Bus Inside have two button, first is Manage bus, Second  is Mange Schedule.\n\n" +
                                               "2.	 Manage Bus have four button is create, retrieve, update and delete. \n\n" +
                                               "3.	Press first button to add the bus info, second button is use to search bus info, third is update bus information, fourth is delete bus information.\n\n" +
                                               "4.	Manage Schedule have four button is create, retrieve, update and delete. \n\n" +
                                               "5.	Press first button to add the schedule information, second button is use to search, third is update schedule information, fourth is delete schedule information.");
        }
    }
    private class sHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"1.	Inside Manage staff button have four button is create, retrieve, update and delete. \n\n"  +
                                               "2.	Press first button to add the staff info, second button is use to search staff Information, \n  third is update staff information, fourth is delete staff information.");
        }
    }
    private class dHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "1.	Driver schedule is allow driver check schedule.");
        }
    }
    private class tHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             JOptionPane.showMessageDialog(null, "1.	Inside Ticket have three button, first is purchase ticket, Second  is Check Purchase information,third is Check Payment Detail. \n\n" + 
                                                 "2.	Press first button to the purchase and payment ticket, second button is use to search Purchase Information, \n  third is search Payment information.");
        }
    }
    
    private class iHelp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null,"1.	Inside innsurance button have four button is create, retrieve, update and delete. \n\n"  +
                                               "2.	Press first button to add the insurance info, second button is use to search insurance Information, \n  third is update Insurance information, fourth is delete insurance information.");
        }
    }


private class back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            new mainMenu(staff);
            setVisible(false);
        }
}

private class quit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
             new LoginPage();
             setVisible(false);
             
        }
}

    public static void main(String[] args) {
        new staffUI();
    }
    
}
