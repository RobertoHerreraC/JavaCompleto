package _23_Excepciones;

import java.util.HashMap;
import java.util.Map;

public class g_minibackend_service {
    static void main() {
        UsuarioService service = new UsuarioService();
        try{
            Usuario usuario = service.obtenerUsuario(99);
            System.out.println("El usuario es: " + usuario.getNombre());
        }catch (UsuarioNoEncontradoException e){
            System.out.println("Error controlado: "+e.getMessage());
        }
    }
}

class Usuario{
    private int id;
    private String nombre;
    public  Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
}

class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(String mensaje){
        super(mensaje);
    }
}

class UsuarioRepository{
    private Map<Integer,Usuario> usuarios = new HashMap<>();

    public UsuarioRepository(){
        usuarios.put(1,new Usuario(1,"Roberto"));
        usuarios.put(2, new Usuario(2,"Kateryn"));
    }
    public Usuario buscarPorId(int id){
        return usuarios.get(id);
    }
}

class UsuarioService{
    private UsuarioRepository repository = new UsuarioRepository();
    public Usuario obtenerUsuario(int id){
        Usuario usuario = repository.buscarPorId(id);
        if(usuario == null){
            throw new UsuarioNoEncontradoException("No existe usuario con id: "+id);
        }
        return usuario;
    }
}
