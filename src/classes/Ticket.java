package classes;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticket  {
	
	private String kind_of_ticket;
	private String Name;
	
    public Ticket() {      	//default constructor

    }
    
	public Ticket(String kind_of_ticket,String name) {   //constructor
		this.kind_of_ticket = kind_of_ticket;
		this.Name=name;
	}

	public String GetName(){
		return Name;
	}
	
	public void SetName(String name) {
		Name=name;
	}
	
	public String ChooseKindOfTicket() {    
		return kind_of_ticket;
	}
	
	void pay() {
		
	} 

}
