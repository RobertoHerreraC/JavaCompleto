package _17_streams;

import java.util.List;

public class map_transformacion {
    static void main() {
        List<String> nombres = List.of("Roberto", "Kateryn", "Ana");
        List<String> nombresMayusculas = nombres.stream()
                .map(n -> n.toUpperCase())
                .toList();

        System.out.println(nombresMayusculas);
    }
}
