package POO.vehicleFleet.interfaz;

public  class Car extends Vehicle {

    private int numberDoors;
    private String boxType;

    public Car(String brand, String model, int year, double price, int doors, String box) {
        super(brand, model,year, price);
        this.numberDoors = doors;
        this.boxType = box;
    }
    public int getNumberDoors() { return numberDoors; }
    public String getBoxType(){
        return boxType;
    }

    @Override
    public double calculateMaintenanceCost() {
        return getBasePrice() * 0.88;
    }

    @Override
    public String fuelType() {
        return "Gasolina 95";
    }

    @Override
    public void showInfo() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║          🚗  AUTOMÓVIL               ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║  Marca/Modelo : %s %s\n", getBrand(), getModel());
        System.out.printf("║  Año          : %d\n", getYear());
        System.out.printf("║  Puertas      : %d\n", numberDoors);
        System.out.printf("║  Caja         : %s\n", boxType);
        System.out.printf("║  Combustible  : %s\n", fuelType());
        System.out.printf("║  Precio       : $%.2f\n", getBasePrice());
        System.out.printf("║  Mantenimiento: $%.2f / año\n", calculateMaintenanceCost());
        System.out.printf("║  Estado       : %s\n", isOn() ? "🟢 Encendido" : "🔴 Apagado");
        System.out.println("╚══════════════════════════════════════╝");
    }



}
