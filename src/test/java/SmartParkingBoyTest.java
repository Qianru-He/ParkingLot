import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
	private ParkingLot aParkingLot = new ParkingLot(2);
	private ParkingLot bParkingLot = new ParkingLot(2);
	private ParkingLot cParkingLot = new ParkingLot(1);

	private GraduateBoy buildParkingBoy(){
		ArrayList<ParkingLot> parkingLots = new ArrayList<>();
		parkingLots.add(aParkingLot);
		parkingLots.add(bParkingLot);
		parkingLots.add(cParkingLot);

		return new SmartParkingBoy(parkingLots);
	}

	@Test
	void should_return_ticket_with_A_when_parking_one_car() {
		GraduateBoy parkingBoy = buildParkingBoy();
		Car car = new Car();
		Ticket ticket = parkingBoy.park(car);
		Car picked = aParkingLot.pickUp(ticket);
		assertEquals(car,picked);
	}

	@Test
	void should_return_ticket_with_B_when_parking_one_car_B_more_than_A() {
		GraduateBoy parkingBoy = buildParkingBoy();
		parkingBoy.park(new Car());
		Car car = new Car();
		Ticket ticket = parkingBoy.park(car);
		Car picked = bParkingLot.pickUp(ticket);
		assertEquals(car,picked);
	}

	@Test
	void should_return_ticket_with_B_when_parking_one_car_B_size_more_than_A() {
		aParkingLot = new ParkingLot(1);
		bParkingLot = new ParkingLot(2);
		GraduateBoy parkingBoy = buildParkingBoy();
		Car car = new Car();
		Ticket ticket = parkingBoy.park(car);
		Car picked = bParkingLot.pickUp(ticket);
		assertEquals(car,picked);
	}
	@Test
	void should_return_ticket_with_A_when_parking_one_car_A_size_more_than_B() {
		aParkingLot = new ParkingLot(2);
		bParkingLot = new ParkingLot(1);
		cParkingLot = new ParkingLot(1);
		GraduateBoy parkingBoy = buildParkingBoy();
		Car car = new Car();
		Ticket ticket = parkingBoy.park(car);
		Car picked = aParkingLot.pickUp(ticket);
		assertEquals(car,picked);
	}

	@Test
	void should_return_throw_exception_when_parking_one_car_A_and_B_is_full() {
		aParkingLot = new ParkingLot(1);
		bParkingLot = new ParkingLot(1);
		GraduateBoy parkingBoy = buildParkingBoy();
		parkingBoy.park(new Car());
		parkingBoy.park(new Car());
		parkingBoy.park(new Car());

		ParkingLotException parkingLotException = assertThrows(ParkingLotException.class,
				() -> parkingBoy.park(new Car()));

		assertEquals("all parking lot is full",parkingLotException.getMessage());
	}
}
