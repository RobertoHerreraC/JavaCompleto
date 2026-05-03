package _21_hilos.runnable_callable;

import java.util.concurrent.Callable;

public class callable_exception {
    static void main() {
        Callable<String> tarea = ()->{
            Thread.sleep(1000);
            return "OK";
        };

        try{
            String resultado = tarea.call();
            System.out.println(resultado);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
