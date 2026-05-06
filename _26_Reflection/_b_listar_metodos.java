package _26_Reflection;

import java.lang.reflect.Method;

public class _b_listar_metodos {
    static void main() {
        Class<?> clazz = ProductoService.class;
        Method[] metodos = clazz.getDeclaredMethods();
        for(Method m : metodos) {
            System.out.println("Metodo:" +m.getName());
        }
    }
}

class ProductoService{
    public void crearProducto(){

    }
    public void listaProductos(){

    }
    private void validarProducto(){

    }
}