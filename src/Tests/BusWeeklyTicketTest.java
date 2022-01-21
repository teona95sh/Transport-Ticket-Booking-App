package Tests;

import classes.BusWeeklyTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BusWeeklyTicketTest {

	
	@Test
	void testSetStartDate() {
		BusWeeklyTicket testBusWeeklyTicket = new BusWeeklyTicket();
		testBusWeeklyTicket.setStartDate("21/01/2022");
		assertEquals("21/01/2022", testBusWeeklyTicket.getStartDate());
	}
	
	@Test
	void testSetEndDate() {
		BusWeeklyTicket testBusWeeklyTicket = new BusWeeklyTicket();
		testBusWeeklyTicket.setEndDate("28/01/2022");
		assertEquals("28/01/2022", testBusWeeklyTicket.getEndDate());
	}
	
	@Test
	void testPrice() {
		BusWeeklyTicket testBusWeeklyTicket = new BusWeeklyTicket();
		assertEquals(36, testBusWeeklyTicket.getPrice());
	}
	
	
	

}
