package classes;

public class BusDailyTicket extends BusTicket{
	
	private String Date;
	private final int Price=14;
	
    public BusDailyTicket() { //default constructor
		
	}
    
	public BusDailyTicket(String kind_of_ticket,String name,String date) { //constructor
		super(kind_of_ticket,name); //extended from BusTicket class
		this.Date=date;
	}
	


	public void setDate(String date) {
		Date = date;
	}
	
	public String getDate() {

		return Date;
	}
	
	public int getPrice() {
		return Price;
	}
	
	

}
