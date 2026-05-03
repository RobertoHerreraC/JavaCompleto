package _4_ejercicios;

import java.util.HashMap;
import java.util.Map;

class InventarioService{
    private Map<String, Integer> stock = new HashMap<>();

    public void agregar(String producto, int cantidad){
        stock.put(producto, stock.getOrDefault(producto,0)+cantidad);
    }

    public void vender(String producto, int cantidad) throws Exception{
        int disponible = stock.getOrDefault(producto,0);
        if(cantidad>disponible) throw new Exception("Stock insuficiente");

        stock.put(producto, disponible-cantidad);
    }
    public void mostrar(){
        System.out.println(stock);
    }
}

public class ejercicio008 {
    static void main() {
        InventarioService inventario = new InventarioService();
        try {
            inventario.agregar("Gaseosa", 5);
            inventario.agregar("chocolate", 10);
            inventario.agregar("platano", 20);
            inventario.mostrar();
            inventario.vender("Gaseosa", 3);
            inventario.vender("chocolate", 8);
            inventario.vender("platano", 20);
            inventario.mostrar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
