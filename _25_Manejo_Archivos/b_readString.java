package _25_Manejo_Archivos;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class b_readString {
    static void main() {
        Path archivo = Path.of("data","mensaje.txt");
        try{
            if(!Files.exists(archivo)){
                System.out.println("El archivo no existe: "+archivo);
                return;
            }
            String contenido = Files.readString(archivo, StandardCharsets.UTF_8);
            System.out.println("Contenido:");
            System.out.println(contenido);
        }catch (Exception e){
            System.err.println("Error leyendo archivo: "+e.getMessage());
        }
    }
}
