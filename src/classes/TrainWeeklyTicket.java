package classes;

public class TrainWeeklyTicket extends TrainTicket {
	
	private String StartDate;
	private String EndDate;
	private final int Price=60;
	
    public TrainWeeklyTicket() { //default constructor
		
	}
	
	public TrainWeeklyTicket(String kind_of_ticket,String name,String startDate,String endDate) { //constructor
		super(kind_of_ticket,name); // //extended from TrainTicket class
		this.EndDate=endDate;
		this.StartDate=startDate;
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
