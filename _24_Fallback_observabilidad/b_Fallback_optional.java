package _24_Fallback_observabilidad;

import java.util.Optional;

public class b_Fallback_optional {
    static void main() {
        Optional<String> usuario = buscarUsuario(99);
        String nombre = usuario.orElse("Desconocido");
        System.out.println("El usuario es: " + nombre);
    }

    public static Optional<String> buscarUsuario(int id){
        return Optional.empty();
    }
}
