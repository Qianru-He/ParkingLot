import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
	private ArrayList<ParkingLot> parkingLots;

	public ParkingBoy(ArrayList<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}
	public List<ParkingLot> getParkingLots(){
		return parkingLots;
	}
	public Ticket park(Car car) throws ParkingLotException {
		for (ParkingLot parkingLot : parkingLots) {
			if (parkingLot.isFull()) {
				continue;
			}
			return parkingLot.park(car);
		}
		throw new ParkingLotException("all parking lot is full");
	}

	public Car pickUp(Ticket ticket) {
		for (ParkingLot parkingLot : parkingLots) {
			if (ticket != null && ticket.getParkingLotID().equals(parkingLot.getUuid())) {
				return parkingLot.pickUp(ticket);
			}
		}
		throw new ParkingLotException("invalid ticket");
	}
}
