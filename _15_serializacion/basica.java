package _15_serializacion;

import java.io.*;

public class basica {
    static void main() {
        Usuario usuario = new Usuario("Roberto",30);
        try{
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.dat"));
//            out.writeObject(usuario);
//            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.dat"));
            Usuario recuperado = (Usuario) in.readObject();
            in.close();
            System.out.println(recuperado);
            System.out.println(in.toString());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Usuario implements Serializable {
    private static final long serialVersionUID=1L;
    private String nombre;
    private int edad;

    public Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
}
