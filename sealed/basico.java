package sealed;

public class basico {
    static void main() {
        Auto auto = new Auto();
        Moto moto = new Moto();
        auto.conducir();
        auto.mostrarTipo();

        moto.conducir();
        moto.mostrarTipo();
    }

    static sealed class Vehiculo permits Auto, Moto{
        public void mostrarTipo(){
            System.out.println("Soy un vehiculo.");
        }
    }

    static final class Auto extends Vehiculo{
        public void conducir(){
            System.out.println("Conduciendo auto");
        }
    }

    static final class Moto extends Vehiculo{
        public void conducir(){
            System.out.println("Conduciendo moto");
        }
    }


}
