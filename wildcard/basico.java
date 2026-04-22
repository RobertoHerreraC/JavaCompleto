package wildcard;

import java.util.ArrayList;
import java.util.List;

public class basico {
    static void main() {
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> nombres = List.of("Kateryn", "Carlos", "Roberto");

        imprimir(nombres);
        imprimir(numeros);

    }

    public static void imprimir(List<?> lista){
        lista.forEach(System.out::println);
    }
}
