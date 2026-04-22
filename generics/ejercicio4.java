package generics;

import java.util.ArrayList;
import java.util.List;

public class ejercicio4 {
    static void main() {
        List<String> nombres = new ArrayList<>();
        nombres.add("Roberto");
        nombres.add("Kateryn");
        nombres.add("Carlos");
        nombres.forEach(nombre->System.out.println(nombre.toUpperCase()));
    }
}
