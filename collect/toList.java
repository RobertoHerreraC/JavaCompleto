package collect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class toList {
    static void main() {
        List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> pares = lista.stream()
                .filter(n->n%2==0)
                .collect(Collectors.toList());
        System.out.println(pares);
    }
}
