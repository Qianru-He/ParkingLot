import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private int size;
	private int capacity;
	private Map<Ticket,Car> cars = new HashMap<>();

	public ParkingLot(int i) {
		this.size = i;
		this.capacity = 0;
	}

	public Ticket park(Car car) {
		if(isFull()){
			return null;//throw exception
		}
		capacity++;
		Ticket ticket = new Ticket();
		cars.put(ticket,car);
		return ticket;
	}

	public boolean isFull() {
		return capacity == size;
	}

	public Car pickUp(Ticket ticket) {
		return cars.remove(ticket);
	}
}
