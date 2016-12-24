package control;

import domain.Schedule;
import da.ScheduleDA;

public class MaintainSchedule {

    private ScheduleDA scheduleDA;

    public MaintainSchedule() {
        scheduleDA = new ScheduleDA();
    }

    public Schedule selectRecord(String ID){
        return scheduleDA.getRecord(ID);
    }
    public String selectRecord1(){
        return scheduleDA.getRecord1();
    }
    
    
    public Schedule getDestination(String destination){
        return scheduleDA.getDestination(destination);
    }

    public void addRecord(Schedule schedule) {
        scheduleDA.addRecord(schedule);
    }
    
    public void getRecord(Schedule schedule) {
        scheduleDA.addRecord(schedule);
    }
    
    public void updateRecord(Schedule schedule) {
        scheduleDA.updateRecord(schedule);
    }
    
    public void deleteRecord(Schedule schedule) {
        scheduleDA.deleteRecord(schedule);
    } 
    
    public String[] getScheduleDestination(){
        return scheduleDA.getScheduleDestination();
    }
    public String[] getBusSeatID() {
        return scheduleDA.getBusSeatID();
    }
    public String[] getscheduleID() {
        return scheduleDA.getscheduleID();
    }
    
    public double[] getTicketPrice1() {
        return scheduleDA.getTicketPrice1();
    }
    
    public String[] getscheduleDate() {
        return scheduleDA.getscheduleDate();
    }
    public String[] getscheduleTime() {
        return scheduleDA.getscheduleTime();
    }
    
}