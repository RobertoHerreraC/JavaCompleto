package _17_streams;

import java.util.List;

public class realista {
    static void main() {
        List<Producto> productos = List.of(
                new Producto("Laptop",2500,3),
                new Producto("Mouse", 50, 0),
                new Producto("Teclado", 120, 5),
                new Producto("Monitor", 800,0)
        );

        double total = productos.stream()
                .filter(p -> p.getStock()>0)
                .mapToDouble(Producto::getPrecio)
                .sum();

        System.out.println(total);

    }
}

class Producto{
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre,double precio,int stock){
        this.nombre=nombre;
        this.precio=precio;
        this.stock=stock;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
