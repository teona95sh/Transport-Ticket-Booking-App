package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.BusSingleTicket;
import classes.BusWeeklyTicket;
import classes.Ticket;

class BusSingleTicketTest {

	@Test
	void testSetBusNumber() {
		BusSingleTicket testBusSingleTicket = new BusSingleTicket();
		testBusSingleTicket.setBusNumber(25);
		assertEquals(25, testBusSingleTicket.getBusNumber());
	}
	
	@Test
	void testSetTime() {
		BusSingleTicket testBusSingleTicket = new BusSingleTicket();
		testBusSingleTicket.setTime("23:59");
		assertEquals("23:59", testBusSingleTicket.getTime());
	}
	
	@Test
	void testSetDate() {
		BusSingleTicket testBusSingleTicket = new BusSingleTicket();
		testBusSingleTicket.setDate("31/12/2022");
		assertEquals("31/12/2022", testBusSingleTicket.getDate());
	}
	
	

}
