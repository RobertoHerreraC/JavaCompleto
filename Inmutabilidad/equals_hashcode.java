package Inmutabilidad;

public class equals_hashcode {
    static void main() {
        Usuario u1 = new Usuario("Roberto", 30);
        Usuario u2 = new Usuario("Roberto", 30);
        Usuario u3 = new Usuario("Carlos", 26);

        System.out.println(u1.equals(u2));
        System.out.println(u1.equals(u3));
        System.out.println(u1.hashCode());
        System.out.println(u1.hashCode() == u2.hashCode());
    }

    record Usuario (String nombre, int edad){

    }
}
