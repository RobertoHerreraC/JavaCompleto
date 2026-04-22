package optional;

import java.util.Optional;

public class orElseThrow {
    static void main() {
        Optional<Usuario> usar = buscarUsuario(2);
        Usuario usuario = usar.orElseThrow(()->new RuntimeException("Usuario no encontrado"));
        System.out.println(usuario.getNombre());
    }
    public static Optional<Usuario> buscarUsuario(int id){
        if(id==1) return Optional.of(new  Usuario("Roberto"));

        return Optional.empty();
    }
}
