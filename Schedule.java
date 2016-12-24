
package domain;

public class Schedule {
    private String ScheduleID;
    private String Departure;
    private String Destination;
    private String BusID;
    private String StaffID;
    private String Time;
    private double TicketPrice;
    private String Date;
    private String SeatID;
    
    public Schedule(){}
    
    public Schedule(String ScheduleID,String Departure,String Destination,String BusID,String StaffID, double TicketPrice,String Date,String SeatID,String Time){
        this.ScheduleID = ScheduleID;
        this.Departure = Departure;
        this.Destination = Destination;
        this.BusID = BusID;
        this.StaffID = StaffID;
        
        this.TicketPrice = TicketPrice;
        this.Date = Date;
        this.SeatID = SeatID;
        this.Time = Time;
    }
     public String getScheduleID() {
        return ScheduleID;
    }

    public void setScheduleID(String ScheduleID) {
        this.ScheduleID = ScheduleID;
    }
    
    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }
    
   
    public String getDestination() {
        return Destination;
    }
    
     public void setDestination(String Destination) {
        this.Destination = Destination;
    }

     
     
   
    
    public String getBusID() {
        return BusID;
    }
     public void setBusID(String BusID) {
        this.Destination = Destination;
    }

     
     
    public String getStaffID() {
        return StaffID;
    }
    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }
    
    

    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    

    public double getTicketPrice() {
        return TicketPrice;
    }
    public void setTicketPrice(double TicketPrice) {
        this.TicketPrice = TicketPrice;
    }
    
    public String getDate() {
        return Date;
    }
    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public String getSeatID() {
        return SeatID;
    }
    public void setSeatID(String SeatID) {
        this.SeatID = SeatID;
    }
    

   
    
    
    
}
