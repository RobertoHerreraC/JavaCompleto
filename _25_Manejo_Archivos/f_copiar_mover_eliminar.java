package _25_Manejo_Archivos;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class f_copiar_mover_eliminar {
    static void main() {
        Path carpeta = Path.of("data");
        Path original = carpeta.resolve("original.txt");
        Path copia = carpeta.resolve("copia.txt");
        Path movido = carpeta.resolve("movido.txt");
        try{
            Files.createDirectories(carpeta);
            Files.writeString(original,"Contenido original", StandardCharsets.UTF_8);
            Files.copy(original,copia, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado");

            Files.move(copia,movido,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido");

            Files.deleteIfExists(original);
            System.out.println("Original eliminado si existia");
        }catch(Exception e){
            System.out.println("Error manejando archivo: "+e.getMessage());
        }
    }
}
