package _19_method_reference;

import java.util.List;

public class forEach {
    static void main() {
        List<Integer> lista = List.of(10,20,30,50);
        lista.forEach(System.out::println);
    }
}
