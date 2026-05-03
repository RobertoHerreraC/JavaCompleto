package _0_Avanzado.Archivo_3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static void main() {

        Path path = Paths.get("Archivo_2.txt");
        if(Files.exists(path)) {
            System.out.println("El archivo existe");
        }

        try{
            String contenido = Files.readString(path);
            System.out.println(contenido);
            Files.copy(path, Paths.get("Archivo_3.txt"));
            Files.delete(path);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
