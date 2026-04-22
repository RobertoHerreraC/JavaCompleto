package lambda;

import java.util.function.Predicate;

public class predicate {
    static void main() {
        Predicate<Integer> esPar = numero -> numero % 2 == 0;
        System.out.println(esPar.test(4));
        System.out.println(esPar.test(7));
    }
}
