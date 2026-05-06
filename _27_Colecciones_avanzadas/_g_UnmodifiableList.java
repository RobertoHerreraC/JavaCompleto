package _27_Colecciones_avanzadas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _g_UnmodifiableList {
    static void main() {
        List<String> original = new ArrayList<String>();
        original.add("a");

        List<String> inmutable = Collections.unmodifiableList(original);
        //inmutable.add("b");
        original.add("c");
        System.out.println(inmutable);

    }
}
