package classes;


public class BusMonthlyTicket extends BusTicket{
	
	private String Month;
	private final int Price=200;
	
    public BusMonthlyTicket() { //default constructor
		
	}
    
	public BusMonthlyTicket(String kind_of_ticket,String name,String month) { //constructor
		super(kind_of_ticket,name); //extended from BusTicket class
		this.Month = month;
	}

	public void setMonth(String month) {
		Month = month;
	}
	
	public String getMonth() {
		return Month;
	}
	
	public int getPrice() {
		return Price;
	}
	
	

}