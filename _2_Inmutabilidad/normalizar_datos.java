package _2_Inmutabilidad;

public class normalizar_datos {
    static void main() {
        try{
            Cliente c1 = new Cliente("    Kateryn    ", "KATERYN@gmail.com");
            System.out.println(c1);
            Cliente c2 = new Cliente(null,null);
            System.out.println(c2);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    record Cliente(String nombre, String email){
        public Cliente{
            if(nombre ==null && email ==null) throw new IllegalArgumentException("Nombre y email son obligatorios");
            nombre = nombre.trim();
            email = email.trim().toLowerCase();
        }
    }
}
