package _20_collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingBy_mapping {
    static void main() {
        List<Usuario> usuaruios = List.of(
            new Usuario("Kateryn","ADMIN"),
            new Usuario("Roberto", "USER"),
            new Usuario("Pedro","ADMIN"),
            new Usuario("Ingrid", "USER")
        );

        Map<String, List<String>> nombresPorRol = usuaruios.stream()
                .collect(Collectors.groupingBy(Usuario::getRol,Collectors.mapping(Usuario::getNombre, Collectors.toList())));

        System.out.println(nombresPorRol);
    }
}

class Usuario{
    private String nombre;
    private String rol;

    public Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }
    public String getRol() {
        return rol;
    }
}
