package _14_anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class validador {
    static void main() throws Exception{
        Usuario usuario = new Usuario("Roberto",null,30);
        Field[] campos = Usuario.class.getDeclaredFields();

        for(Field campo : campos){
            if(campo.isAnnotationPresent(Obligatorio.class)){
                campo.setAccessible(true);
                Object valor = campo.get(usuario);
                if(valor == null || valor.toString().isEmpty()) System.out.println("El campo "+ campo.getName()+" es obligatorio");
            }
        }

    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Obligatorio{

}

class Usuario{
    @Obligatorio
    private String nombre;
    @Obligatorio
    private String email;
    private int edad;
    public Usuario(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }
}
