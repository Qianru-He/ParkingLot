import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartParkingBoy extends GraduateBoy {
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
		Collections.sort(parkingLots);
		return parkingLots.get(0);
	}

}
