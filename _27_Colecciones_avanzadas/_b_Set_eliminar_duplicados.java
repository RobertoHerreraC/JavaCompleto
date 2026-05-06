package _27_Colecciones_avanzadas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _b_Set_eliminar_duplicados {
    static void main() {
        List<String> lista = List.of("A", "B", "A", "C");
        System.out.println(lista);
        Set<String> set = new HashSet<>(lista);
        System.out.println(set);
    }
}
