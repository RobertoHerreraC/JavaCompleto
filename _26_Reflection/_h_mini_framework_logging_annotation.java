package _26_Reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class _h_mini_framework_logging_annotation {
    static void main() throws Exception{
        UsuarioService service = new UsuarioService();
        Class<?> clazz = service.getClass();
        for(Method metodo:clazz.getDeclaredMethods()){
            if(metodo.isAnnotationPresent(Log.class)){
                System.out.println("[LOG] Iniciando: "+metodo.getName());
                metodo.invoke(service);
                System.out.println("[LOG] Finalizando: "+metodo.getName());
                System.out.println();
            }
        }
    }
}

class UsuarioService{
    @Log
    public void crearusuario(){
        System.out.println("Creando usuario");
    }
    public void listaUsuarios(){
        System.out.println("Listando usuarios");
    }
    @Log
    public void eliminarusuario(){
        System.out.println("Eliminando usuario");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Log{

}