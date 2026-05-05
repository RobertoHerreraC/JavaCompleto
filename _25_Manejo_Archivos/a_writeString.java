package _25_Manejo_Archivos;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class a_writeString {
    static void main() {
        Path carpeta = Path.of("data");
        Path archivo = carpeta.resolve("mensaje.txt");

        try{
            Files.createDirectories(carpeta);
            Files.writeString(
                    archivo,
                    "Hola desde Java NIO.2",
                    StandardCharsets.UTF_8
            );
            System.out.println("Archivo creado: "+archivo.toAbsolutePath());
        }catch (Exception e){
            System.out.println("Error escribiendo archivo: "+e.getMessage());
        }
    }
}
