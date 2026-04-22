package Inmutabilidad;


public class record_basico {
    static void main() {
        Usuario usuario = new Usuario("Roberto",30);
        System.out.println(usuario.nombre);
        System.out.println(usuario.edad);
        System.out.println(usuario);
    }

    record Usuario(String nombre, int edad){}
}

