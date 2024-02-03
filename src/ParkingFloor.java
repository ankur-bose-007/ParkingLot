import enums.ParkingSlotType;
import enums.VehicleType;

import java.util.*;

public class ParkingFloor {
    private final int id;
    private final Map<ParkingSlotType, TreeSet<ParkingSlot>> availableSlots;
    private final Map<ParkingSlotType, Set<ParkingSlot>> occupiedSlots;

    public ParkingFloor(int id, List<ParkingSlotType> slotTypeList, List<ParkingSlot> slots) {
        this.id = id;
        availableSlots = new HashMap<>();
        occupiedSlots = new HashMap<>();
        initializeSlotTypes(slotTypeList);
        initializeSlots(slots);
    }

    private void initializeSlotTypes(List<ParkingSlotType> slotTypeList){
         slotTypeList.forEach(slotType -> availableSlots.put(slotType, new TreeSet<>(
                 Comparator.comparingInt(ParkingSlot::getId)
         )));
         slotTypeList.forEach(slotType -> occupiedSlots.put(slotType, new HashSet<>()));
    }

    private void initializeSlots(List<ParkingSlot> slots){
        slots.forEach(slot -> availableSlots.get(slot.getParkingSlotType()).add(slot));
    }

    public int getId() {
        return id;
    }

    public Set<ParkingSlot> getAvailableSlots() {
        Set<ParkingSlot> parkingSlots = new HashSet<>();

        for(TreeSet<ParkingSlot> parkingSlots1: availableSlots.values())
            parkingSlots.addAll(parkingSlots1);

        return parkingSlots;
    }

    public Set<ParkingSlot> getOccupiedSlots() {
        Set<ParkingSlot> parkingSlots = new HashSet<>();

        for(Set<ParkingSlot> parkingSlots1: occupiedSlots.values())
            parkingSlots.addAll(parkingSlots1);

        return parkingSlots;
    }

    public Set<ParkingSlot> getOccupiedSlots(VehicleType vehicleType){
        ParkingSlotType parkingSlotType = getParkingSlotTypeByVehicleType(vehicleType);

        return occupiedSlots.get(parkingSlotType);
    }

    public void addSlot(ParkingSlot parkingSlot){
        availableSlots.get(parkingSlot.getParkingSlotType()).add(parkingSlot);
    }

    public ParkingSlot getAvailableSlotForVehicleAndPark(Vehicle vehicle){
        ParkingSlotType parkingSlotType = getParkingSlotTypeByVehicleType(vehicle.getVehicleType());
        if(!availableSlots.get(parkingSlotType).isEmpty()){
            ParkingSlot parkingSlot = availableSlots.get(parkingSlotType).removeFirst();
            parkingSlot.setVehicle(vehicle);
            parkingSlot.setAvailable(true);
            occupiedSlots.get(parkingSlotType).add(parkingSlot);
            return parkingSlot;
        }

        return null;
    }

    public void releaseParkingSlot(ParkingSlot slot){
        occupiedSlots.get(slot.getParkingSlotType()).remove(slot);
        slot.setAvailable(true);
        slot.setVehicle(null);
        availableSlots.get(slot.getParkingSlotType()).add(slot);
    }

    private ParkingSlotType getParkingSlotTypeByVehicleType(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.Car) || vehicleType.equals(VehicleType.Truck))
            return ParkingSlotType.FourWheeler;
        return ParkingSlotType.TwoWheeler;
    }

    public Set<ParkingSlot> getAvailableSlots(VehicleType vehicleType){
        ParkingSlotType parkingSlotType = getParkingSlotTypeByVehicleType(vehicleType);

        return availableSlots.get(parkingSlotType);
    }

    public boolean isSlotAvailable(Vehicle vehicle){
        ParkingSlotType parkingSlotType = getParkingSlotTypeByVehicleType(vehicle.getVehicleType());
        return !availableSlots.get(parkingSlotType).isEmpty();
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
                "id=" + id +
                '}';
    }
}
