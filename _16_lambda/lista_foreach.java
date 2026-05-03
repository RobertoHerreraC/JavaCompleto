package _16_lambda;

import java.util.List;

public class lista_foreach {
    static void main() {
        List<String> nombres = List.of("Roberto", "Kateryn", "Ana");
        nombres.forEach(nombre -> System.out.println(nombre.toUpperCase()));
    }
}
