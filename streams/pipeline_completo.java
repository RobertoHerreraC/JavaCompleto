package streams;

import java.util.List;

public class pipeline_completo {
    static void main() {
        List<Integer> numero = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> resultado = numero.stream()
                .filter(m->m>3)
                .map(n->n*10)
                .toList();
        System.out.println(resultado);
    }
}
