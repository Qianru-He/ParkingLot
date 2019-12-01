import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
	private int size;
	private int capacity;
	private UUID uuid;
	private Map<Ticket,Car> cars = new HashMap<>();

	public ParkingLot(int i) {
		this.size = i;
		this.capacity = 0;
		this.uuid = UUID.randomUUID();
	}

	public Ticket park(Car car) {
		if(isFull()){
			return null;//throw exception
		}
		capacity++;
		Ticket ticket = new Ticket(uuid);
		cars.put(ticket,car);
		return ticket;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public Car pickUp(Ticket ticket) {
		return cars.remove(ticket);
	}

	public boolean hasTicket(Ticket ticket) {
		return ticket.getParkingLotID().equals(uuid);
	}
}
