package _26_Reflection;

import java.lang.reflect.Field;

public class _c_listar_atributos {
    static void main() {
        Class<?> clazz = Producto.class;
        Field[] campos = clazz.getDeclaredFields();
        for(Field campo : campos){
            System.out.println("Campo: "+campo.getName()+ " | Tipo: "+campo.getType().getSimpleName());
        }
    }
}

class Producto{
    private int id;
    private String nombre;
    private double precio;
}
