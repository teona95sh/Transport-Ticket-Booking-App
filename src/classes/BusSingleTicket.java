package classes;

public class BusSingleTicket extends BusTicket{
	
	private int BusNumber;
	private String Date;
	private String Time;
	private final int Price=6;
	
    public BusSingleTicket() { //default constructor
		
	}
    
    public BusSingleTicket(String kind_of_ticket,String name,int busNumber,String date,String time) { // constructor
		super(kind_of_ticket,name);  // extended from BusTicket class
		this.BusNumber = busNumber;
		this.Time =time;      
		this.Date=date;
	}
    
	public String kind(String kind_of_ticket) {
		return  kind_of_ticket;
	}
	
	public String name(String name) {
		return  name;
	}
	
	public int getPrice() {
		return Price;
	}
	
	
	public void setDate(String date) {
		Date=date;
	}
	
	 public void setTime(String time) {
		 Time = time;
	 }
	 
	public void setBusNumber(int busNumber) {

		BusNumber = busNumber;
	}
	public int getBusNumber()
	{
		return BusNumber;
	}

	public String getDate() {

		return Date;
	}
	
	public String getTime() {

		return Time;
	}
	

}