package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class refleccion {
    static void main() throws Exception{
        Method metodo = Servicio2.class.getDeclaredMethod("guardar");
        if(metodo.isAnnotationPresent(Log2.class)) System.out.println("El metodo guardar tiene @Log2");
        else System.out.println("El metodo guardar tiene @Log");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Log2{

}

class Servicio2{
    @Log2
    public void guardar(){
        System.out.println("Servicio guardado");
    }
}

