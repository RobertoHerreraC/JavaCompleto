package sealed;

public class intermedio {
    static void main() {
        Pago p1 = new PagoTarjeta();
        Pago p2 = new PagoEfectivo();
        Pago p3 = new PagoTransferencia();

        p1.procesarPago();
        p2.procesarPago();
        p3.procesarPago();

    }

    static abstract sealed class Pago permits PagoTarjeta, PagoEfectivo, PagoTransferencia{
        public abstract void procesarPago();
    }

    static final class PagoTarjeta extends Pago{
        @Override
        public void procesarPago() {
            System.out.println("Procesando pago con tarjeta.");
        }
    }

    static final class PagoEfectivo extends Pago{
        @Override
        public void procesarPago() {
            System.out.println("Procesando pago con efectivo.");
        }
    }

    static final class PagoTransferencia extends Pago{
        @Override
        public void procesarPago() {
            System.out.println("Procesando pago con transferencia.");
        }
    }
}
