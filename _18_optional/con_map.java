package _18_optional;

import java.util.Optional;

public class con_map {
    static void main() {
        Optional<Usuario> user = Optional.of(new Usuario("Roberto"));

        String nombre = user.map(u -> u.getNombre()).orElse("Desconocido");

        System.out.println(nombre);


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
