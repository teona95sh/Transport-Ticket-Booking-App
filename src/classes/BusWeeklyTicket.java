package classes;

public class BusWeeklyTicket extends BusTicket{
	
	private String StartDate;
	private String EndDate;
	private final int Price=36; 
	
    public BusWeeklyTicket() { //default constructor
		
	}
    
	public BusWeeklyTicket(String kind_of_ticket,String name,String startDate,String endDate) { //constructor
		super(kind_of_ticket,name); //extended from BusTicket class
		this.StartDate = startDate;
		this.EndDate = endDate;

	}
	
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	
	public String getStartDate() {
		return StartDate;
	}
	
	public String getEndDate() {
		return EndDate;
	}
	
	public int getPrice() {
		return Price;
	}
	

}
