package _25_Manejo_Archivos;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class h_csv_basico {
    static void main() {
        Path archivo = Path.of("data","producto.csv");
        try{
            Files.createDirectories(archivo.getParent());
            String csv = """
                    nombre,precio,stock
                    Laptop,2500,3
                    Mouse,50,0
                    Teclado,120,5
                    """;

            Files.writeString(archivo,csv, StandardCharsets.UTF_8);

            try(BufferedReader reader = Files.newBufferedReader(archivo,StandardCharsets.UTF_8)) {
                String linea;
                boolean primeraLinea = true;
                while((linea = reader.readLine())!=null){
                    if(primeraLinea){
                        primeraLinea = false;
                        continue;
                    }
                    String[] partes = linea.split(",");

                    String nombre = partes[0];
                    double precio = Double.parseDouble(partes[1]);
                    int stock = Integer.parseInt(partes[2]);

                    Producto producto = new Producto(nombre,precio,stock);
                    if(producto.stock()>0) System.out.println(producto);
                }
            }
        }catch(Exception e){
            System.out.println("Error manejando csv: "+e.getMessage());
        }
    }
}

record Producto(String nombre, double precio, int stock){}
