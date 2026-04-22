package serializacion;

import com.fasterxml.jackson.databind.ObjectMapper;

public class objeto_a_JSON {
    static void main() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Producto producto = new Producto("Laptop",2500.0);
            String json = mapper.writeValueAsString(producto);
            System.out.println(json);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Producto{
    public String nombre;
    public double precio;
    public Producto() {}

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
