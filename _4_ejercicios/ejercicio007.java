package _4_ejercicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Producto{
    int id;
    String nombre;
    double precio;

    public Producto(int id, String nombre, double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

}

class Pedido{
    int id;
    List<Producto> productos;
    LocalDate fecha;

    public Pedido(int id, List<Producto> productos) throws Exception{
        if(productos.isEmpty())throw new Exception("Pedido vacio");
        this.id=id;
        this.productos=productos;
        this.fecha=LocalDate.now();
    }

    public double calcularTotal(){
        double total =0;
        for(Producto p: productos){
            total += p.precio;
        }
        return total;
    }
}
public class ejercicio007 {
    static void main() {
        try{
            List<Producto> productos = new ArrayList<>();
            productos.add(new Producto(1, "Laptop",26000));
            productos.add(new Producto(2, "Celular",1200));
            productos.add(new Producto(3, "Teclado",50));

            Pedido pedido = new Pedido(1,productos);
            System.out.println(pedido.calcularTotal());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
