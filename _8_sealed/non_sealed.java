package _8_sealed;

public class non_sealed {
    static void main() {
        EmpleadoFijo fijo = new EmpleadoFijo();
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras();

        fijo.trabajar();
        empleadoPorHoras.trabajar();

    }

    static sealed class Empleado permits EmpleadoFijo, EmpleadoTemporal{
        public void trabajar(){
            System.out.println("Trabajando...");
        }
    }
    static final class EmpleadoFijo extends Empleado{

    }

    static non-sealed class EmpleadoTemporal extends Empleado{

    }

    static class EmpleadoPorHoras extends EmpleadoTemporal{

    }

}
