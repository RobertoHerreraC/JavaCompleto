package _22_Try_with_Resourse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class c_escribir_BufferedWriter {
    static void main() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("salida.txt"))){
            writer.write("Primera linea");
            writer.newLine();

            writer.write("Segunda linea");
            writer.newLine();

            writer.write("Tercera linea");
            writer.newLine();

            System.out.println("Archivo escrito correctamente");
        }catch (IOException e){
            System.out.println("Error al abrir archivo: "+e.getMessage());
        }
    }
}
