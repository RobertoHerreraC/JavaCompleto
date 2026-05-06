package _26_Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class _g_detectar_annotation_runtime {
    static void main() {
        Class<?> clazz = PedidoService.class;
        for(Method metodo :clazz.getDeclaredMethods()){
            if(metodo.isAnnotationPresent(Auditable.class)) System.out.println("Metodo auditable: "+metodo.getName());
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Auditable{
}

class PedidoService{
    @Auditable
    public void crearPedido(){

    }
    public void listarPedidos(){
    }
    @Auditable
    public void cancelarPedido(){

    }
}

