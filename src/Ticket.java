public class Ticket {
    private static int idCounter = 0;
    private int id;
    private final ParkingFloor parkingFloor;
    private final ParkingSlot parkingSlot;
    private final Vehicle vehicle;

    public Ticket(ParkingFloor parkingFloor, ParkingSlot parkingSlot, Vehicle vehicle) {
        idCounter+=1;
        id = idCounter;
        this.parkingFloor = parkingFloor;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", parkingFloor=" + parkingFloor +
                ", parkingSlot=" + parkingSlot +
                ", vehicle=" + vehicle +
                '}';
    }
}
