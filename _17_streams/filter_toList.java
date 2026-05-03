package _17_streams;

import java.util.List;

public class filter_toList {
    static void main() {
        List<Integer> numero = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> pares = numero.stream()
                .filter(n -> n%2==0)
                .toList();

        System.out.println(pares);
    }
}
