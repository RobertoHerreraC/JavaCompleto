package _10_switch_expressions;

public class ejercicio5 {
    static void main() {
        TipoDescuento descuento = TipoDescuento.PREMIUM;
        double precio = 100.0;

        double precioFinal = switch(descuento){
            case NINGUNO -> precio;
            case BASICO -> precio *0.9;
            case PREMIUM -> precio * 0.8;
        };
        System.out.println(precioFinal);
    }

    enum TipoDescuento{
        NINGUNO,BASICO,PREMIUM
    }
}
