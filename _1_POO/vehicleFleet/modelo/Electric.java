package _1_POO.vehicleFleet.modelo;

public interface Electric {
    int getBatteryLevel();
    void chargeBattery(int porcentage);
    double calculateAutonomy();

    default void showBatteryStatus(int level){
        String bar = "█".repeat(level / 10)+"░".repeat(10-level/10);
        System.out.printf("Battery: [%s] %d%%\n",bar,level);
    }
}
