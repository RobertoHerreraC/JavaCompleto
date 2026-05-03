package _12_wildcard;

import java.util.ArrayList;
import java.util.List;

public class copiar_lista {
    static void main() {
        List<Integer> origen = List.of(1, 2, 3, 4, 5);
        List<Number> destino = new ArrayList<Number>();

        copiar(origen,destino);
        System.out.print(destino);

    }
    public static void copiar(List<? extends Number> origen, List<? super Number> destino){
        for(Number n :origen) destino.add(n);
    }
}
