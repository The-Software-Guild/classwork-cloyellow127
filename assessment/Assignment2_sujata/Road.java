import java.util.ArrayList;

public class Road {
    ArrayList<Vehicle> vehicles;

    Road(){
        vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void printRoad(){
        for(Vehicle vehicle : vehicles){
            vehicle.getType();
        }
    }
}
