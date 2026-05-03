package _1_POO.vehicleFleet.interfaz;

import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private String companyName;
    private List<Vehicle> fleet;


    public FleetManager(String companyName){
        this.companyName = companyName;
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        fleet.add(vehicle);
    }

    public void showFleet(){
        System.out.printf("\nFleet : %s (%d vehicles)\n", companyName, fleet.size());
        for(Vehicle vehicle : fleet){
            System.out.println(vehicle);
        }
    }

    public double calculateTotalFleetCost(){
        double total= 0;
        for(Vehicle v : fleet){
            double cost = v.calculateMaintenanceCost();
            System.out.printf("  %-20s → $%.2f\n",
                    v.getBrand() + " " + v.getModel(), cost);
            total +=  cost;
        }
        System.out.printf("\nTotal Fleet Cost : $%.2f\n", total);
        return total;
    }
}
