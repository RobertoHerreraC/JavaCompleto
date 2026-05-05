package _25_Manejo_Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class j_mini_batch_leer_reporte {
    static void main() {
        Path input = Path.of("data","productos-batch.csv");
        Path output = Path.of("data","reporte-productos.txt");
        try{
            prepararArchivo(input);
            List<Producto1> productos = leerProductos(input);
            List<Producto1> disponibles = productos.stream()
                    .filter(Producto1::disponible)
                    .toList();
            double totalValorizado = disponibles.stream()
                    .mapToDouble(Producto1::valorInventario)
                    .sum();

            escribirReporte(output,disponibles,totalValorizado);
            System.out.println("Reporte generado en: "+output.toAbsolutePath());
        }catch(Exception ex){
            System.err.println("Error en Batch:"+ex.getMessage());
        }
    }
    private static void prepararArchivo(Path input) throws Exception{
        Files.createDirectories(input.getParent());
        String csv = """
                nombre,precio,stock
                Laptop,2500,3
                Mouse,50,0
                Teclado,120,5
                Monitor,800,2
                """;
        Files.writeString(input, csv, StandardCharsets.UTF_8);
    }

    private static List<Producto1> leerProductos(Path input)throws Exception{
        List<Producto1> productos = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8)){
            String linea;
            boolean cabecera = true;
            while((linea = reader.readLine())!=null){
                if(cabecera){
                    cabecera = false;
                    continue;
                }
                String[] partes = linea.split(",");
                String nombre = partes[0];
                double precio = Double.parseDouble(partes[1]);
                int stock = Integer.parseInt(partes[2]);
                productos.add(new Producto1(nombre,precio,stock));

            }
        }
        return productos;
    }

    private static void escribirReporte(Path output, List<Producto1> disponible, double totalValorizado) throws Exception{
        try(BufferedWriter writer = Files.newBufferedWriter(output,StandardCharsets.UTF_8)){
            writer.write("REPORTE DE PRODUCTOS DISPONIBLES");
            writer.newLine();
            writer.write("---------------------------------");
            writer.newLine();

            for(Producto1 p :  disponible){
                writer.write(
                        "%s | precio: %.2f | stock: %d | valor: %.2f"
                                .formatted(p.nombre(),p.precio(),p.stock(),p.valorInventario())
                );
                writer.newLine();
            }
            writer.newLine();
            writer.write("Cantidad disponibles: "+disponible.size());
            writer.newLine();
            writer.write("Total valorizado: %.2f".formatted(totalValorizado));
            writer.newLine();
        }
    }
}

record Producto1(String nombre, double precio, int stock){
    boolean disponible(){
        return stock>0;
    }

    double valorInventario(){
        return precio * stock;
    }
}
