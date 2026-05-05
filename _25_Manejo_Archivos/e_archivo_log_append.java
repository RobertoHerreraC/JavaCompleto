package _25_Manejo_Archivos;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class e_archivo_log_append {
    static void main() {
        Path carpeta = Path.of("logs");
        Path log = carpeta.resolve("app.log");
        try{
            Files.createDirectories(carpeta);
            String evento = LocalDateTime.now()+" INFO - Aplicacion iniciada\n";
            Files.writeString(
                    log,
                    evento,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
            System.out.println("Log escrito");
        }catch (Exception e){
            System.out.println("Error escribiendo log: "+e.getMessage());
        }
    }
}
