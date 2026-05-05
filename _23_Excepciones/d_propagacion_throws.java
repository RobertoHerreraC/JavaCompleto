package _23_Excepciones;

import java.io.IOException;

public class d_propagacion_throws {
    static void main() {
        try{
            servicio();
        }catch (IOException e){
            System.out.println("Error capturado en main: "+e.getMessage());
        }
    }

    public static void servicio() throws IOException{
        repositorio();
    }

    public static void repositorio() throws IOException{
        throw new IOException("Error conectando al archivo de datos");
    }
}
