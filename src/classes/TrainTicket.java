package classes;

public class TrainTicket extends Ticket{

    public TrainTicket() { //default constructor
		
	}
    
	public TrainTicket(String kind_of_ticket,String name) { // constructor
		super(kind_of_ticket,name); //extended from Ticket class
	}

}
