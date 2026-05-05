package _24_Fallback_observabilidad;

import java.util.Optional;

public class c_Fallback_optional_orElseGet {
    static void main() {
        Optional<String> nombre = Optional.empty();

        String resultado = nombre.orElseGet(()->generarNombreDefault());
        System.out.println(resultado);
    }

    public static String generarNombreDefault(){
        System.out.println("Generando valor por defecto");
        return "Usuario invitado";
    }
}
