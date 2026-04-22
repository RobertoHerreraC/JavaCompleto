package wildcard;

import java.util.ArrayList;
import java.util.List;

public class super_escritura {
    static void main() {
        List<Number> lista = new ArrayList<>();
        agregar(lista);

        System.out.println(lista);
    }

    public static void agregar(List<? super Integer> lista){
        lista.add(1);
        lista.add(2);
        lista.add(3);
    }
}
