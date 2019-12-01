import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
	@Test
	public void should_return_a_ticket_when_park_one_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		Car car = new Car();
		//when
		Ticket ticket = parkingLot.park(car);
		//then
		assert(ticket != null);
	}
	@Test
	public void should_not_full_when_create_a_new_parking_lot(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		//when
		boolean isFull = parkingLot.isFull();
		//then
		assertFalse(isFull);
	}

	@Test
	public void should_return_true_when_parking_lot_not_full(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		//when
		boolean isFull = parkingLot.isFull();
		//then
		assertFalse(isFull);
	}
	@Test
	public void should_return_false_when_parking_lot_is_full(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		//when
		parkingLot.park(new Car());
		boolean isFull = parkingLot.isFull();
		//then
		assertTrue(isFull);
	}

	@Test
	public void should_return_ticket_when_parking_lot_can_park_one_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		//when
		Ticket ticket = parkingLot.park(new Car());
		//then
		assertNotNull(ticket);
	}

	@Test
	public void should_return_null_when_parking_is_full_and_park_one_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		parkingLot.park(new Car());
		//when
		Car car = new Car();
		Ticket ticket = parkingLot.park(car);
		//then
		assertNull(ticket);
	}

	@Test
	public void should_return_car_when_pick_up_parked_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		Car car = new Car();
		Ticket ticket = parkingLot.park(car);
		//when
		Car pickUpCar = parkingLot.pickUp(ticket);
		//then
		assertEquals(car,pickUpCar);
	}

	@Test
	public void should_return_null_when_pick_parked_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);
		Car car = new Car();
		Ticket ticket = parkingLot.park(car);
		parkingLot.pickUp(ticket);
		//when
		Car discarded = parkingLot.pickUp(ticket);
		//then
		assertNull(discarded);
	}

	@Test
	public void should_return_null_when_use_fake_ticket_pick_parked_car(){
		//given
		ParkingLot parkingLot = new ParkingLot(1);

		//when
		parkingLot.park(new Car());
		Ticket fakeTicket = new Ticket();
		Car car1 = parkingLot.pickUp(fakeTicket);

		//then
		assertNull(car1);
	}
}
