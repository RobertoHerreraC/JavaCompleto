package _9_pattern_matching;

public class ejercicio4 {
    static void main() {
        Pago pago = new PagoTarjeta("1234-56789");
        if(pago instanceof PagoTarjeta tarjeta){
            System.out.println("Pago con tarjeta: "+tarjeta.numeroTarjeta);
        }else if(pago instanceof PagoEfectivo efectivo){
            System.out.println("Pago en efectivo: "+efectivo.monto);
        }

    }
}

abstract class Pago{}

class PagoTarjeta extends Pago{
    String numeroTarjeta;
    PagoTarjeta(String numeroTarjeta){
        this.numeroTarjeta = numeroTarjeta;
    }
}

class PagoEfectivo extends Pago{
    double monto;
    PagoEfectivo(double monto){
        this.monto = monto;
    }
}
