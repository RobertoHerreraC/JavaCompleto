package _20_collect;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class toSet {
    static void main() {
        List<String> nombres = List.of("Roberto","Kateryn","Ingrid","Carlos", "Kateryn", "Roberto");

        Set<String> unicos = nombres.stream()
                .collect(Collectors.toSet());

        System.out.println(unicos);
    }
}
