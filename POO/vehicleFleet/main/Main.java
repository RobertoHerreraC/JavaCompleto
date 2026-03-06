package POO.vehicleFleet.main;

import POO.vehicleFleet.interfaz.Car;
import POO.vehicleFleet.interfaz.ElectricCar;
import POO.vehicleFleet.interfaz.FleetManager;
import POO.vehicleFleet.interfaz.Truck;

public class Main {
    static void main() {
        Car sedan = new Car("Toyota", "Corolla", 2022, 25000, 4, "Automatic");
        Car deport = new Car("Ford", "Mustang", 2023, 55000, 2, "Manual");

        Truck loadTruck = new Truck("Volvo", "FH16", 2021, 120000, 25.0, 6);
        ElectricCar tesla = new ElectricCar("Tesla", "Model 3", 2024, 45000, 4, 560);

        //Abstract
        sedan.showInfo();
        tesla.showInfo();
        loadTruck.showInfo();

        //Herency
        sedan.turnOn();
        sedan.turnOff();
        sedan.turnOff();

        loadTruck.loadMerchandise(20.0);
        loadTruck.loadMerchandise(30.0);

        tesla.chargeBattery(0);
        tesla.calculateAutonomy();

        FleetManager fleet = new FleetManager("Transporte POO SA.");
        fleet.addVehicle(sedan);
        fleet.addVehicle(deport);
        fleet.addVehicle(loadTruck);
        fleet.addVehicle(tesla);

        fleet.showFleet();
        fleet.calculateTotalFleetCost();
    }
}
