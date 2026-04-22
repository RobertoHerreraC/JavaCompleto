package method_reference;

import java.util.List;

public class contructor_reference {
    static void main() {
        List<String> nombres = List.of("Roberto", "Kateryn");

        List<Usuario> usuarios = nombres.stream()
                .map(Usuario::new)
                .toList();

        System.out.println(usuarios);
    }
}
