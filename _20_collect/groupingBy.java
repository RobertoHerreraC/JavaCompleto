package _20_collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingBy {
    static void main() {
        List<String> nombres = List.of("Ana","Roberto", "Kateryn", "Ingrid", "Carlos", "Maria" );

        Map<Integer,List<String>> agrupados = nombres.stream()
                .collect(Collectors.groupingBy(n -> n.length()));

        System.out.println(agrupados);
    }
}
