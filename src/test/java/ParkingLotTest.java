import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
	public ParkingBoy buildParkingBoy(){
		ParkingLot aParkingLot = new ParkingLot(1);
		ParkingLot bParkingLot = new ParkingLot(1);

		ArrayList<ParkingLot> parkingLots = new ArrayList<>();
		parkingLots.add(aParkingLot);
		parkingLots.add(bParkingLot);

		return new ParkingBoy(parkingLots);
	}

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
		Ticket fakeTicket = new Ticket(UUID.randomUUID());
		Car car1 = parkingLot.pickUp(fakeTicket);

		//then
		assertNull(car1);
	}

	@Test
	public void should_return_ticket_when_park_car() {
		//given
		ParkingBoy boy = buildParkingBoy();
		Car car = new Car();

		//when
		Ticket ticket = boy.park(car);

		//then
		assertNotNull(ticket);
	}

	@Test
	public void should_return_ticket_when_first_parking_lot_is_full_and_second_is_not_full() {
		//given
		ParkingBoy boy = buildParkingBoy();
		boy.park(new Car());

		//when
		Ticket ticket = boy.park(new Car());

		//then
		assertNotNull(ticket);
	}

	@Test
	public void should_return_null_when_all_parking_lot_is_full() {
		//given
		ParkingBoy boy = buildParkingBoy();
		boy.park(new Car());
		boy.park(new Car());

		//when
		Ticket ticket = boy.park(new Car());

		//then
		assertNull(ticket);
	}

	@Test
	public void should_return_true_when_check_ticket_and_parking_lot() {
		ParkingLot parkingLot = new ParkingLot(1);
		Ticket ticket = parkingLot.park(new Car());

		//given
		boolean has = parkingLot.hasTicket(ticket);

		//then
		assertTrue(has);
	}

	@Test
	public void should_return_car_when_pick_up_after_park_a_car() {
		//given
		ParkingBoy boy = buildParkingBoy();
		Car parkedCar = new Car();
		Ticket ticket = boy.park(parkedCar);

		//when
		Car pickedCar = boy.pickUp(ticket);

		//then
		assertEquals(parkedCar, pickedCar);
	}

	@Test
	public void should_return_car_when_pick_up_after_park_a_car_in_second_parking_lot() {
		//given
		ParkingBoy boy = buildParkingBoy();
		boy.park(new Car());

		Car parkedCar = new Car();
		Ticket ticket = boy.park(parkedCar);

		//when
		Car pickedCar = boy.pickUp(ticket);

		//then
		assertEquals(parkedCar, pickedCar);
	}

	@Test
	public void should_return_null_when_use_a_fake_ticket_to_pick() {
		//given
		ParkingBoy boy = buildParkingBoy();
		boy.park(new Car());


		Ticket ticket = new Ticket(UUID.randomUUID());

		//when
		Car pickedCar = boy.pickUp(ticket);

		//then
		assertNull(pickedCar);
	}
}
