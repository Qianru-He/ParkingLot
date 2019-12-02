import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
	private int size;
	private UUID uuid;
	private Map<Ticket, Car> cars = new HashMap<>();


	public UUID getUuid() {
		return uuid;
	}

	public ParkingLot(int i) {
		this.size = i;
		this.uuid = UUID.randomUUID();
	}

	public Ticket park(Car car) throws ParkingLotException {
		if(!isFull()){
			Ticket ticket = new Ticket(uuid);
			cars.put(ticket, car);
			return ticket;
		}
		throw new ParkingLotException("parking lot is full");
	}

	public boolean isFull() {
		return cars.size() == size;
	}

	public Car pickUp(Ticket ticket) {
		return cars.remove(ticket);
	}
	public int freeCapacity(){
		return size-cars.size();
	}
}
