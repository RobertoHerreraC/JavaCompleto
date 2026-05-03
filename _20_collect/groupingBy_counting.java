package _20_collect;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class groupingBy_counting {
    static void main() {
        List<Producto> productos = List.of(
                new Producto("Laptop", "Tecnologia"),
                new Producto("Mouse", "Tecnologia"),
                new Producto("Silla", "Hogar"),
                new Producto("Mesa", "Hogar"),
                new Producto("Teclado", "Tecnologia")
        );

        Map<String,Long> conteo = productos.stream()
                .collect(Collectors.groupingBy(Producto::getCategoria, Collectors.counting()));
        System.out.println(conteo);
    }
}

class Producto{
    private String nombre;
    private String categoria;

    public Producto(String nombre, String categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCategoria() {
        return categoria;
    }
}
