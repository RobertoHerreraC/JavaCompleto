package _25_Manejo_Archivos;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class i_copiar_archivo_FileChannel {
    static void main() {
        Path carpeta = Path.of("data");
        Path origen = carpeta.resolve("origen_channel.txt");
        Path destino = carpeta.resolve("destino_channel.txt");
        try{
            Files.createDirectories(carpeta);
            Files.writeString(origen, "Contenido para copiar con FileChannel", StandardCharsets.UTF_8);
            try(
                    FileChannel canalOrigen = FileChannel.open(origen, StandardOpenOption.READ);
                    FileChannel canalDestino = FileChannel.open(
                            destino,
                            StandardOpenOption.CREATE,
                            StandardOpenOption.WRITE,
                            StandardOpenOption.TRUNCATE_EXISTING
                    );
                    ){
                canalOrigen.transferTo(0,canalOrigen.size(),canalDestino);
            }
            System.out.println("Archivo copiado correctamente con FileChannel");
        }catch(Exception ex){
            System.err.println("Error usando FileChannel:"+ex.getMessage());
        }
    }
}
