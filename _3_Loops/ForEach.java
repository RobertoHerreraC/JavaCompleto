package _3_Loops;

import java.util.HashMap;
import java.util.Map;

public class ForEach {
    static void main() {

        HashMap<String, String> map = new HashMap<>();
        map.put("Perro", "Luna");
        map.put("Gato", "Michi");
        map.put("Conejo", "Bugs");

        for(Map.Entry<String,String> value : map.entrySet()) {
            System.out.println(value);
        }
    }
}
