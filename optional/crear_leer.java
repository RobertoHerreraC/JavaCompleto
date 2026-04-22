package optional;

import java.util.Optional;

public class crear_leer {
    static void main() {
        Optional<String> nombre = Optional.of("Roberto");
        nombre.ifPresent(n -> System.out.println("Nombre:"+n));
    }
}
