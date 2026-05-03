package _4_ejercicios;

class UsuarioController{
    private UsuarioService service = new UsuarioService();

    public void crearUsuario(int id, String nombre, String email){
        try{
            service.crear(new Usuario(id,nombre,email));
            System.out.println("Usuario creado con exito");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

public class ejercicio010 {
    public static void main(String[] args) {
        try{
            UsuarioController controller = new UsuarioController();
            controller.crearUsuario(1,"Roberto","roberto@gmail.com");
            controller.crearUsuario(2,"Kateryn","kateryn@gmail.com");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
