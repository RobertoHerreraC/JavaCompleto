package Avanzado.Archivos_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
    static void main() {
        Path path = Paths.get("Archivo.txt");
        try{
            Files.createFile(path);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
