package method_reference;

import java.util.List;

public class metodo_estatico {
    static void main() {
        List<String> numeros = List.of("10","20","30","40","50","60");
        List<Integer> lista = numeros.stream()
                .map(Integer::parseInt)
                .toList();

        System.out.println(lista);


    }
}
