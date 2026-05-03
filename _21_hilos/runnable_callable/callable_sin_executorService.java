package _21_hilos.runnable_callable;

import java.util.concurrent.Callable;

public class callable_sin_executorService {
    static void main() throws Exception {
        //no crea hilo
        Callable<Integer> tarea = ()->{
            return 10+20;
        };

        Integer resultado = tarea.call();
        System.out.println(resultado);
    }
}
