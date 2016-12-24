package control;

import domain.busInfo;
import da.BusInfoDA;

public class MaintainBus{

    private BusInfoDA busDA;

    public MaintainBus() {
        busDA = new BusInfoDA();
    }

    public busInfo selectRecord(String ID){
        return busDA.getRecord(ID);
    }
    public String selectRecord1(){
        return busDA.getRecord1();
    }
    
    public void addRecord(busInfo bus) {
        busDA.addRecord(bus);
    }
    public busInfo getName(String name){
        return busDA.getName(name);
    }
    
    public void getRecord(busInfo bus) {
        busDA.addRecord(bus);
    }
    
    public void updateRecord(busInfo bus) {
        busDA.updateRecord(bus);
    }
    
    public void deleteRecord(busInfo bus) {
        busDA.deleteRecord(bus);
    } 
    
    public String[] getAllBusNo(){
        return busDA.getAllBusNo();
    }
    public String[] getAllBusID(){
        return busDA.getAllBusID();
    }
}