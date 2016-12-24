
package control;

import domain.Seat;
import da.SeatDA;

public class MaintainSeat {

    private SeatDA seatDA;

    public MaintainSeat() {
        seatDA = new SeatDA();
    }
    public Seat selectRecord(String ID){
        return seatDA.getRecord(ID);
    }
    public String[] getAllSeatID(){
        return seatDA.getAllSeatID();
    }
   
   public String getID() {
       return seatDA.getID();
   }
   public void addRecord(Seat seat) {
       seatDA.addRecord(seat);
   }
   public void updateRecord(Seat seat) {
       seatDA.updateRecord(seat);
   }
   public void deleteRecord(Seat seat){ 
       seatDA.deleteRecord(seat);
   }
   
}
