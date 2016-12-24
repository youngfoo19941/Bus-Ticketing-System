package control;

import domain.Staff;
import da.StaffDA;

public class MaintainStaff {

    private StaffDA staffDA;

    public MaintainStaff() {
        staffDA = new StaffDA();
    }

    public Staff selectRecord(String ID){
        return staffDA.getRecord(ID);
    }
    public String selectRecord1(){
        return staffDA.getRecord1();
    }
    
    public Staff getName(String staffName){
        return staffDA.getName(staffName);
    }

    public void addRecord(Staff staffMember) {
        staffDA.addRecord(staffMember);
    }
    
    public void getRecord(Staff staffMember) {
        staffDA.addRecord(staffMember);
    }
    
    public void updateRecord(Staff staffMember) {
        staffDA.updateRecord(staffMember);
    }
    
    public void updatepassword(Staff password){
        staffDA.updatepassword(password);
    }
    public void deleteRecord(Staff staffMember) {
        staffDA.deleteRecord(staffMember);
    } 
    
    public String[] getStaffName(){
        return staffDA.getStaffName();
    }
    public String[] getid(){
        return staffDA.getid();
    }
    
}