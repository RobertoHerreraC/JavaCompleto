package Avanzado.Archivo_2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    static void main() {
        Path path = Paths.get("Archivo_2.txt");
        try{
            Files.writeString(path, "Hello World");
            Files.writeString(path,"\nNueva linea", StandardOpenOption.APPEND);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
