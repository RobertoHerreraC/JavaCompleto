package streams;

import java.util.ArrayList;
import java.util.List;

public class reduce {
    static void main() {
        List<Integer> lista = List.of(1, 2, 3, 4, 5);
        int suma = lista.stream()
                .reduce(0,(ac,n)->ac+n);
        System.out.println(suma);
    }
}
