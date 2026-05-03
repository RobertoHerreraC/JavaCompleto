package _18_optional;

import java.util.Optional;

public class ofNullable_orElse {
    static void main() {
        String valor = null;
        Optional<String> nombre = Optional.ofNullable(valor);
        String resultado = nombre.orElse("Desconocido");
        System.out.println(resultado);
    }
}
