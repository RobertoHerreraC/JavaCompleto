package _15_serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class lista_objeto {
    static void main() {
        List<Usuario1> lista = new ArrayList<>();
        lista.add(new Usuario1("Roberto",30));
        lista.add(new Usuario1("Maria",40));
        lista.add(new Usuario1("Kateryn",31));

        try{
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
//            out.writeObject(lista);
//            out.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            List<Usuario1> recuperados = (List<Usuario1>) ois.readObject();
            ois.close();
            System.out.println(recuperados);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Usuario1 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    public Usuario1(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario1{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
