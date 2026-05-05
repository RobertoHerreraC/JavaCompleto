package _25_Manejo_Archivos;

import java.nio.file.Files;
import java.nio.file.Path;

public class g_listar_archivos_directorio {
    static void main() {
        Path carpeta = Path.of("data");
        try{
            Files.createDirectories(carpeta);
            try(var stream = Files.list(carpeta)) {
                stream.forEach(path->{
                    System.out.println(path.getFileName());
                });
            }
        }catch(Exception e){
            System.out.println("Error listando directorio: "+e.getMessage());
        }
    }
}
