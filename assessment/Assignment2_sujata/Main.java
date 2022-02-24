import java.util.Arrays;

public class Main {
    public static void main(String args[]){
        Vehicle[] vehicles = new Vehicle[]{new Vehicle(), new Car(), new Bus(), new Truck()};

        Road r = new Road();
        
        for(int i = 0; i < vehicles.length; i++) r.addVehicle(vehicles[i]);

        r.printRoad();
       
    }
}
