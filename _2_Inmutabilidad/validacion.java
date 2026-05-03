package _2_Inmutabilidad;

public class validacion {
    static void main() {
        Producto p1 = new Producto("Caramelo", 2.5);
        System.out.println(p1);
        try{
            Producto p2 = new Producto("", -5);
            System.out.println(p2);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    record Producto(String nombre, double precio){
        public Producto{
            if(nombre.isEmpty() && nombre==null) {throw new IllegalArgumentException("El nombre es obligatorio.");}
            if(precio<0) {throw new IllegalArgumentException("El precio no puede ser negativo.");}
        }
    }
}
