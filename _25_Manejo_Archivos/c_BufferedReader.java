package _25_Manejo_Archivos;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class c_BufferedReader {
    static void main() {
        Path archivo = Path.of("data","nombre.txt");
        try{
            Files.createDirectories(archivo.getParent());
            Files.writeString( archivo,"Kateryn\nRoberto\n", StandardCharsets.UTF_8);
            try(BufferedReader reader = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)){
                String linea;
                while((linea=reader.readLine())!=null){
                    System.out.println("Nombre: "+ linea);
                }
            }
        }catch (Exception e){
            System.out.println("Error procesando archivo: "+e.getMessage());
        }
    }
}
