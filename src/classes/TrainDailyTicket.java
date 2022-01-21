package classes;

public class TrainDailyTicket extends TrainTicket{
	
	private String Date;
	private final int Price =20;
	
    public TrainDailyTicket() { //default constructor
		
	}
    
	public TrainDailyTicket(String kind_of_ticket,String name,String date) { //constructor
		super(kind_of_ticket,name); //extended from TrainTicket class
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
