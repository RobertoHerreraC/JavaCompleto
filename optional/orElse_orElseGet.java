package optional;

import java.util.Optional;

public class orElse_orElseGet {
    static void main() {
        Optional<String> nombre = Optional.of("Roberto");

        System.out.println("Con orElse");
        String r1 = nombre.orElse(generarValorPorDefecto());
        System.out.println("Resultado: "+r1);

        System.out.println("Con orElseGet");
        String r2 = nombre.orElseGet(() -> generarValorPorDefecto());
        System.out.println("Resultado: "+r2);

    }

    public static String generarValorPorDefecto(){
        System.out.println("Generando valor");
        return "Desconocido";
    }
}
