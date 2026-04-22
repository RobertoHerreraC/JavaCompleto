package wildcard;

import java.util.ArrayList;
import java.util.List;

public class extends_lectura {
    static void main() {
        List<Integer> lista = List.of(20,50,50,25,87,30);
        System.out.println(promedio(lista));
    }

    public static double promedio(List<? extends Number> lista){
        double suma = 0;
        for(Number n :lista){
            suma += n.doubleValue();
        }
        return suma/lista.size();
    }
}
