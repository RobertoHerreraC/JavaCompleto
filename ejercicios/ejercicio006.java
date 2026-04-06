package ejercicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Usuario{
    int id;
    String nombre;
    String email;
    LocalDate fechaRegistro;

    public Usuario(int id, String nombre, String email){
        this.id=id;
        this.nombre=nombre;
        this.email=email;
        this.fechaRegistro=LocalDate.now();
    }
}

class UsuarioService{
    private List<Usuario> usuarios = new ArrayList<>();

    public void crear(Usuario u)throws Exception{
        if(u.email==null || u.email.isEmpty()) throw new Exception("El email no puede estar vacio");

        for(Usuario us:usuarios){
            if(us.id==u.id) throw new Exception("El usuario ya existe");
        }

        usuarios.add(u);
    }

    public Usuario buscar(int id){
        for(Usuario us:usuarios){
            if(us.id==id) return us;
        }
        return null;
    }

    public void eliminar(int id){
        usuarios.removeIf(u->u.id==id);
    }

    public List<Usuario> listar(){
        return usuarios;
    }
}

public class ejercicio006 {

    static void main() {
        try{
            UsuarioService usuarioService = new UsuarioService();
            usuarioService.crear(new Usuario(1, "Roberto", "roberto@gmail.com"));
            usuarioService.crear(new Usuario(2, "Kateryn", "kateryn@gmail.com"));
            usuarioService.crear(new Usuario(3, "Juan", "juan@gmail.com"));
            usuarioService.crear(new Usuario(4, "Gianela", "gianela@gmail.com"));
            System.out.println(usuarioService.buscar(1).id);
            usuarioService.eliminar(3);
            System.out.println(usuarioService.listar().toString());


        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
