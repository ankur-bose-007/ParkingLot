import enums.ParkingSlotType;
import enums.VehicleType;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("WB1", VehicleType.Car, "black");
        Vehicle vehicle2 = new Vehicle("WB2", VehicleType.Truck, "red");
        Vehicle vehicle3 = new Vehicle("WB3", VehicleType.Bike, "blue");
        Vehicle vehicle4 = new Vehicle("WB3", VehicleType.Car, "yellow");
        Vehicle vehicle5 = new Vehicle("WB3", VehicleType.Truck, "green");
        Vehicle vehicle6 = new Vehicle("WB3", VehicleType.Bike, "grey");

        ParkingSlot parkingSlot1 = new ParkingSlot(1, ParkingSlotType.TwoWheeler);
        ParkingSlot parkingSlot2 = new ParkingSlot(2, ParkingSlotType.FourWheeler);
        ParkingSlot parkingSlot3 = new ParkingSlot(1, ParkingSlotType.TwoWheeler);
        ParkingSlot parkingSlot4 = new ParkingSlot(2, ParkingSlotType.FourWheeler);

        List<ParkingSlot> floor1Slots = List.of(parkingSlot1, parkingSlot2);
        List<ParkingSlot> floor2Slots = List.of(parkingSlot3, parkingSlot4);

        List<ParkingSlotType> parkingSlotTypeList = Arrays.asList(ParkingSlotType.TwoWheeler, ParkingSlotType.FourWheeler);

        ParkingFloor parkingFloor1 = new ParkingFloor(1, parkingSlotTypeList, floor1Slots);
        ParkingFloor parkingFloor2 = new ParkingFloor(2, parkingSlotTypeList, floor2Slots);

        List<ParkingFloor> dpParkingFloors = List.of(parkingFloor1, parkingFloor2);

        ParkingLot parkingLot = new ParkingLot("DP parking lot", "Kolkata", dpParkingFloors);

        parkingLot.displayFreeSlotsPerFloorForVehicleType(vehicle1.getVehicleType());
        parkingLot.displayFreeSlotsPerFloorForVehicleType(vehicle2.getVehicleType());
        parkingLot.displayFreeSlotsPerFloorForVehicleType(vehicle3.getVehicleType());

        System.out.println(parkingLot.assignTicket(vehicle1));
        System.out.println(parkingLot.assignTicket(vehicle2));
        System.out.println(parkingLot.assignTicket(vehicle3));

        System.out.println(parkingLot.assignTicket(vehicle4));
        System.out.println(parkingLot.assignTicket(vehicle5));
        System.out.println(parkingLot.assignTicket(vehicle6));
    }
}