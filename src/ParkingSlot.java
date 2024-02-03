import enums.ParkingSlotType;

public class ParkingSlot {
    private final int id;
    private final ParkingSlotType parkingSlotType;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSlot(int id, ParkingSlotType parkingSlotType) {
        this.id = id;
        this.parkingSlotType = parkingSlotType;
        this.vehicle = null;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id=" + id +
                '}';
    }
}
