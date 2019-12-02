import java.util.ArrayList;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
	public SmartParkingBoy(ArrayList<ParkingLot> parkingLots) {
		super(parkingLots);
	}
	@Override
	public Ticket park(Car car) throws ParkingLotException {
		ParkingLot parkingLot = findBiggestCapacity(getParkingLots());
		if (parkingLot.isFull()) {
			throw new ParkingLotException("all parking lot is full");
		}
		return parkingLot.park(car);
	}

	private ParkingLot findBiggestCapacity(List<ParkingLot> parkingLots){
		ParkingLot desParkingLot = null;
		for (ParkingLot parkingLot : parkingLots) {
			if (desParkingLot == null) {
				desParkingLot = parkingLot;
				continue;
			}
			if (desParkingLot.freeCapacity() < parkingLot.freeCapacity()) {
				desParkingLot = parkingLot;
			}

		}
		return desParkingLot;
	}

}
