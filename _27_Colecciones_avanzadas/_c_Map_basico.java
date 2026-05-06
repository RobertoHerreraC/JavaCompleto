package _27_Colecciones_avanzadas;

import java.util.HashMap;
import java.util.Map;

public class _c_Map_basico {
    static void main() {
        Map<String, Integer> edades = new HashMap<>();
        edades.put("Kateryn",31);
        edades.put("Roberto",30);
        System.out.println(edades.get("Roberto"));
    }
}
