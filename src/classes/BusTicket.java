package classes;

public class BusTicket extends Ticket {

    public BusTicket() { //default constructor
    	
    }
    
	public BusTicket(String kind_of_ticket,String name) {  // constructor
		super(kind_of_ticket,name); //extended from Ticket class
	}

}