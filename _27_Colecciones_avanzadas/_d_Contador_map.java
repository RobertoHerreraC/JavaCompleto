package _27_Colecciones_avanzadas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _d_Contador_map {
    static void main() {
        List<String> palabras = List.of("a", "b", "a", "c", "b");
        Map<String, Integer> contador = new HashMap<>();

        for(String palabra : palabras){
            contador.put(palabra, contador.getOrDefault(palabra,0)+1);
        }
        System.out.println(contador);
    }
}
