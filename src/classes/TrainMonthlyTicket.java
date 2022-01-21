package classes;


public class TrainMonthlyTicket extends TrainTicket{

	private String Month;
	private final int Price=240;
	
    public TrainMonthlyTicket() { //default constructor
		
	}
    
	public TrainMonthlyTicket(String kind_of_ticket,String name,String month) { //constructor
		super(kind_of_ticket,name); //extended from TrainTicket class
		this.Month=month;
	}


	public void setMonth(String month) {
		Month = month;
	}
	
	public String getMonth(){
		return Month;
	}
	
	public int getPrice() {
		return Price;
	}
	
	

}
