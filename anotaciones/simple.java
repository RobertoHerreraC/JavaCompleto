package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class simple {
    static void main() {
        Servicio servicio = new Servicio();
        servicio.guardar();
    }
}

@Target(ElementType.METHOD)
@interface Log{

}


class Servicio{
    @Log
    public void guardar(){
        System.out.println("Guardando...");
    }
}