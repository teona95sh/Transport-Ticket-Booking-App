package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.BusSingleTicket;
import classes.BusWeeklyTicket;
import classes.TrainSingleTicket;

class TrainSingleTicketTest {

	@Test
	void testSetStartTrainStation() {
		TrainSingleTicket testTrainSingleTicket = new TrainSingleTicket();
		testTrainSingleTicket.setStartTrainStation("Rishon Lezzion");
		assertEquals("Rishon Lezzion", testTrainSingleTicket.getStartTrainStation());
	}
	
	@Test
	void testSetEndTrainStation() {
		TrainSingleTicket testTrainSingleTicket = new TrainSingleTicket();
		testTrainSingleTicket.setEndTrainStation("Rishon Lezzion");
		assertEquals("Rishon Lezzion", testTrainSingleTicket.getEndTrainStation());
	}

	@Test
	void testSetTime() {
		TrainSingleTicket testTrainSingleTicket = new TrainSingleTicket();
		testTrainSingleTicket.setTime("00:00");
		assertEquals("00:00", testTrainSingleTicket.getTime());
	}
	
	@Test
	void testSetDate() {
		TrainSingleTicket testTrainSingleTicket = new TrainSingleTicket();
		testTrainSingleTicket.setDate("3/12/2022");
		assertEquals("3/12/2022", testTrainSingleTicket.getDate());
	}
	
}
