package collect;

import java.util.List;
import java.util.stream.Collectors;

public class joining {
    static void main() {
        List<String> nombres = List.of("Kateryn", "Roberto", "Ingrid", "Carlos");
        String unidos = nombres.stream()
                .collect(Collectors.joining(", "));
        System.out.println(unidos);
    }
}
