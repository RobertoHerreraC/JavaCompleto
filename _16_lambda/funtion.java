package _16_lambda;

import java.util.function.Function;

public class funtion {
    static void main() {
        Function<String, Integer> longitud = texto -> texto.length();
        System.out.println(longitud.apply("Java"));
    }
}
