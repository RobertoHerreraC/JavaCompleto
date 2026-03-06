package POO.vehicleFleet.interfaz;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double basePrice;
    private boolean on;

    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = price;
        this.on = false;
    }

    public void turnOn(){
        if(!on){
            on = true;
        }else{
            System.out.println("The vehicle is already running.");
        }


    }

    public void turnOff(){
        if(on){
            on = false;
        }else{
            System.out.println("The vehicle is already turned off.");
        }

    }

    public String getBrand(){
        return brand;
    }
    public String getModel(){ return model; }
    public int getYear(){ return year; }
    public double getBasePrice(){
        return basePrice;
    }
    public boolean isOn(){
        return on;
    }

    public void setBasePrice(double price){
        if(price>0){
            this.basePrice = price;
        }else{
            throw new IllegalArgumentException("The price must be positive.");
        }
    }

    public abstract double calculateMaintenanceCost();
    public abstract String fuelType();
    public abstract void showInfo();

    @Override
    public String toString(){
        return String.format("[%s] %s %s (%d) - $%.2f",
                getClass().getSimpleName(), brand, model, year, basePrice);
    }
}
