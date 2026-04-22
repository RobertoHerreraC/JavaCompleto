package wildcard;

import java.util.ArrayList;
import java.util.List;

public class validacion {
    static void main() {
        List<Integer> lista = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Double> lista2 = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);

        System.out.println(max(lista));
        System.out.println(max(lista2));

    }

    public static double max(List<? extends Number> lista){
        double max = Double.MIN_VALUE;
        for(Number n : lista){
            double valor = n.doubleValue();
            if(valor>max)max=valor;
        }
        return max;
    }
}
