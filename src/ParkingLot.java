import enums.ParkingSlotType;
import enums.VehicleType;

import java.util.List;
import java.util.Set;

public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloorList;

    public ParkingLot(String name, String address, List<ParkingFloor> parkingFloorList) {
        this.name = name;
        this.address = address;
        this.parkingFloorList = parkingFloorList;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void addFloor(int id, List<ParkingSlotType> slotTypeList, List<ParkingSlot> parkingSlotList){
        parkingFloorList.add(new ParkingFloor(id, slotTypeList, parkingSlotList));
    }

    public void addSlotToAFloor(ParkingFloor parkingFloor, ParkingSlot parkingSlot){
        parkingFloor.addSlot(parkingSlot);
    }

    public synchronized Ticket assignTicket(Vehicle vehicle){

        ParkingFloor parkingFloor = getAvailableFloor(vehicle);
        if(parkingFloor != null) {
            ParkingSlot parkingSlot = getAvailableSlotInFloor(parkingFloor, vehicle);

            if(parkingSlot != null) return new Ticket(parkingFloor, parkingSlot, vehicle);
        }

        System.out.println("Slots not available");
        return null;
    }

    public void unpark(Ticket ticket){
        ticket.getParkingFloor().releaseParkingSlot(ticket.getParkingSlot());
    }

    private ParkingSlot getAvailableSlotInFloor(ParkingFloor parkingFloor, Vehicle vehicle){
        return parkingFloor.getAvailableSlotForVehicleAndPark(vehicle);
    }

    private ParkingFloor getAvailableFloor(Vehicle vehicle){
        ParkingFloor parkingFloor = null;

        for(ParkingFloor floor: parkingFloorList){
            if(floor.isSlotAvailable(vehicle)) return floor;
        }

        return null;
    }

    public void displayFreeSlotsPerFloorForVehicleType(VehicleType vehicleType){
        for(ParkingFloor parkingFloor: parkingFloorList) {
            Set<ParkingSlot> parkingSlotSet = parkingFloor.getAvailableSlots(vehicleType);
            System.out.println("Free slots available for floor " + parkingFloor.getId() + " is " + parkingSlotSet.size());
        }
    }

    public void displayOccupiedSlotsPerFloorForVehicleType(VehicleType vehicleType){
        for(ParkingFloor parkingFloor: parkingFloorList) {
            Set<ParkingSlot> parkingSlotSet = parkingFloor.getOccupiedSlots(vehicleType);
            System.out.println("Occupied slots available for floor " + parkingFloor.getId() + " is " + parkingSlotSet.size());
        }
    }
}
