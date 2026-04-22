package collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class toMap {
    static void main() {
        List<Usuario2> usuarios= List.of(
                new Usuario2(1,"Kateryn"),
                new Usuario2(2,"Roberto")
        );

        Map<Integer,String> mapa = usuarios.stream()
                .collect(Collectors.toMap(
                        Usuario2::getId,
                        Usuario2::getNombre
                ));

        System.out.println(mapa);
    }
}

class Usuario2 {
    private int id;
    private String nombre;
    public Usuario2(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}
