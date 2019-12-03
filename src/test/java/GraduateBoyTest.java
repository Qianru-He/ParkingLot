import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class GraduateBoyTest {

	@Test
	public void should_return_ticket_when_park_car() {
		//given
		GraduateBoy boy = buildParkingBoy();
		Car car = new Car();

		//when
		Ticket ticket = boy.park(car);

		//then
		assertNotNull(ticket);
	}

	@Test
	public void should_return_ticket_when_first_parking_lot_is_full_and_second_is_not_full() {
		//given
		GraduateBoy boy = buildParkingBoy();
		boy.park(new Car());

		//when
		Ticket ticket = boy.park(new Car());

		//then
		assertNotNull(ticket);
	}

	@Test
	public void should_return_null_when_all_parking_lot_is_full() {
		//given
		GraduateBoy boy = buildParkingBoy();
		boy.park(new Car());
		boy.park(new Car());

		//when
		ParkingLotException parkingLotException = assertThrows(ParkingLotException.class,
				() -> boy.park(new Car()));

		//then
		assertEquals("all parking lot is full",parkingLotException.getMessage());
	}



	@Test
	public void should_return_car_when_pick_up_after_park_a_car() {
		//given
		GraduateBoy boy = buildParkingBoy();
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
		GraduateBoy boy = buildParkingBoy();
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
		GraduateBoy boy = buildParkingBoy();
		boy.park(new Car());
		Ticket ticket = new Ticket(UUID.randomUUID());

		//when
		ParkingLotException parkingLotException = assertThrows(ParkingLotException.class,
				() -> boy.pickUp((ticket)));

		//then
		assertEquals("invalid ticket",parkingLotException.getMessage());
	}

	private GraduateBoy buildParkingBoy(){
		ParkingLot aParkingLot = new ParkingLot(1);
		ParkingLot bParkingLot = new ParkingLot(1);

		ArrayList<ParkingLot> parkingLots = new ArrayList<>();
		parkingLots.add(aParkingLot);
		parkingLots.add(bParkingLot);

		return new GraduateBoy(parkingLots);
	}
}