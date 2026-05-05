package _25_Manejo_Archivos;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class d_BufferedWriter {
    static void main() {
        Path archivo = Path.of("data","reporte.txt");
        try{
            Files.createDirectories(archivo.getParent());
            try(BufferedWriter writer = Files.newBufferedWriter(archivo, StandardCharsets.UTF_8)){
                writer.write("REPORTE");
                writer.newLine();
                writer.write("--------");
                writer.newLine();
                writer.write("Total usuario: 3");
                writer.newLine();
                writer.write("Estado: OK");
                writer.newLine();
            }
            System.out.println("Reporte generado");
        }catch(Exception e){
            System.out.println("Error generando reporte: "+e.getMessage());
        }
    }
}
