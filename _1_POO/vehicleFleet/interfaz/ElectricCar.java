package _1_POO.vehicleFleet.interfaz;

import _1_POO.vehicleFleet.modelo.Electric;

public class ElectricCar extends Car implements Electric {
    private int batteryLevel;
    private double rangeKM;

    public ElectricCar(String brand, String model, int year,
                       double price, int doors, double rangeKM) {
        super(brand,model, year,price, doors, "Automatic");
        this.rangeKM = rangeKM;
        this.batteryLevel = 100;
    }

    @Override
    public double calculateMaintenanceCost(){
        return getBasePrice() * 0.04;
    }

    @Override
    public String fuelType() {
        return "Electric";
    }

    @Override
    public void showInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       ⚡  AUTO ELÉCTRICO             ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║  Marca/Modelo : %s %s\n", getBrand(), getModel());
        System.out.printf("║  Año          : %d\n", getYear());
        System.out.printf("║  Autonomía    : %.0f km (100%%)\n", rangeKM);
        System.out.printf("║  Precio       : $%.2f\n", getBasePrice());
        System.out.printf("║  Mantenimiento: $%.2f / año\n", calculateMaintenanceCost());
        System.out.printf("║  Estado       : %s\n", isOn() ? "🟢 Encendido" : "🔴 Apagado");
        showBatteryStatus(batteryLevel);  // método de la interfaz Electrico
        System.out.println("╚══════════════════════════════════════╝");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    @Override
    public void chargeBattery(int porcentage) {
        batteryLevel = Math.min(batteryLevel + porcentage, 100);
        System.out.println("Battery level: " + batteryLevel);
    }

    @Override
    public double calculateAutonomy() {
        return rangeKM * (batteryLevel /100.0);
    }
}
