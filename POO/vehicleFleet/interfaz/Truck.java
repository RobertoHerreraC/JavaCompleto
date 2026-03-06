package POO.vehicleFleet.interfaz;

public class Truck extends Vehicle {
    private double loadCapacityTons;
    private int numberAxes;

    public Truck(String brand, String model, int year, double price,
                 double loadCapacityTons, int numberAxes) {
        super(brand, model, year, price);
        this.loadCapacityTons = loadCapacityTons;
        this.numberAxes = numberAxes;
    }


    @Override
    public double calculateMaintenanceCost() {
        return getBasePrice() * 0.15 + (numberAxes * 500);
    }

    @Override
    public String fuelType() {
        return "Diesel";
    }

    @Override
    public void showInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          🚚  CAMIÓN                  ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║  Marca/Modelo : %s %s\n", getBrand(), getModel());
        System.out.printf("║  Año          : %d\n", getYear());
        System.out.printf("║  Cap. Carga   : %.1f toneladas\n", loadCapacityTons);
        System.out.printf("║  Ejes         : %d\n", numberAxes);
        System.out.printf("║  Combustible  : %s\n", fuelType());
        System.out.printf("║  Precio       : $%.2f\n", getBasePrice());
        System.out.printf("║  Mantenimiento: $%.2f / año\n", calculateMaintenanceCost());
        System.out.printf("║  Estado       : %s\n", isOn() ? "🟢 Encendido" : "🔴 Apagado");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public void loadMerchandise(double tons){
        if(tons <= loadCapacityTons){
            System.out.printf("Loading %.1f tons in %s %s\n",tons,getBrand(), getModel());
        }else{
            System.out.printf("Exceeds the maximum capacity of %.1f tons!\n",loadCapacityTons);
        }
    }

    public double getLoadCapacityTons(){ return loadCapacityTons; }
}
