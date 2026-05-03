package _19_method_reference;

import java.util.List;

public class instancia_clase {
    static void main() {
        List<String> nombres = List.of("roberto", "kateryn","carlos","ingrid");

        List<String> mayusculas = nombres.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(mayusculas);

    }
}
