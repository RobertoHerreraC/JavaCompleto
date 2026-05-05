package _23_Excepciones;

import java.io.IOException;

public class b_checked_exception {
    static void main() {
        try{
            leerArchivo();
        }catch (IOException e){
            System.out.println("Error leyendo archivo: "+e.getMessage());
        }
    }

    public static void leerArchivo()throws IOException{
        throw new IOException("archivo.txt no existe");
    }
}
