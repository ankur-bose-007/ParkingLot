import enums.VehicleType;

public class Vehicle {
    private final String registrationNumber;
    private final VehicleType vehicleType;
    private final String color;

    public Vehicle(String registrationNumber, VehicleType vehicleType, String color) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", vehicleType=" + vehicleType +
                ", color='" + color + '\'' +
                '}';
    }
}
