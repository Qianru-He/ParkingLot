import java.util.ArrayList;

public class ParkingBoy {
	private ArrayList<ParkingLot> parkingLots;

	public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public Ticket park(Car car) {
		for (ParkingLot parkingLot :parkingLots) {
			Ticket ticket = parkingLot.park(car);
			if (ticket != null) {
				return ticket;
			}
		}
		return null;
	}

	public Car pickUp(Ticket ticket) {
		for (ParkingLot parkingLot :parkingLots) {
			if (parkingLot.hasTicket(ticket)) {
				return parkingLot.pickUp(ticket);
			}
		}
		return null;
	}
}
