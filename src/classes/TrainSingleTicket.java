package classes;

public class TrainSingleTicket extends TrainTicket {
	private String StartTrainStation;
	private String EndTrainStation;
	private String Time;
	private String Date;
	private final int Price=10;
	
    public TrainSingleTicket() { //default constructor
		
	}
	
	public TrainSingleTicket(String kind_of_ticket,String name,String startStation,String endStation,String time,String date) { // constructor
		super(kind_of_ticket,name); // //extended from TrainTicket class
		this.StartTrainStation=startStation;
		this.EndTrainStation=endStation;
		this.Date=date;
		this.Time=time;
	}
	
	public void setStartTrainStation(String startTrainStation) {
		StartTrainStation = startTrainStation;
	}

	public void setEndTrainStation(String endTrainStation) {
		EndTrainStation = endTrainStation;
	}

	public void setTime(String time) {
		Time = time;
	}

	public void setDate(String date) {
		Date = date;
	}
	
	public String getStartTrainStation()
	{
		return StartTrainStation;
	}
	
	public String getEndTrainStation()
	{
		return EndTrainStation;
	}
	
	public String getDate() {

		return Date;
	}
	
	public int getPrice() {
		return Price;
	}
	
	public String getTime() {

		return Time;
	}
	

}