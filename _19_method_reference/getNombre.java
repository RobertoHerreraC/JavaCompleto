package _19_method_reference;

import java.util.List;

public class getNombre {
    static void main() {
        List<Usuario> usuarios = List.of(
                new Usuario("Kateryn"),
                new Usuario("Ingrid"),
                new Usuario("Roberto"),
                new Usuario("Carlos")
        );

        List<String> nombres = usuarios.stream()
                .map(Usuario::getNombre)
                .toList();
        System.out.println(nombres);

    }
}

class Usuario{
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
