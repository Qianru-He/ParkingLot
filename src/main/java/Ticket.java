import java.util.UUID;

public class Ticket {
	private UUID parkingLotID;

	public Ticket(UUID parkingLotID) {
		this.parkingLotID = parkingLotID;
	}

	public UUID getParkingLotID() {
		return parkingLotID;
	}
}
