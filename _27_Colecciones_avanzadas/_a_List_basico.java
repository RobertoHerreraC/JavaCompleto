package _27_Colecciones_avanzadas;

import java.util.ArrayList;
import java.util.List;

public class _a_List_basico {
    static void main() {
        List<String> nombres = new ArrayList<>();
        nombres.add("Roberto");
        nombres.add("Kateryn");
        nombres.add("Carlos");

        for(String nombre : nombres){
            System.out.println(nombre);
        }
    }
}
