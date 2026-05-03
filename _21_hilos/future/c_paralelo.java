package _21_hilos.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class c_paralelo {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            Future<String> fa = executor.submit(()->tarea("A"));
            Future<String> fb = executor.submit(()->tarea("B"));
            Future<String> fc = executor.submit(()->tarea("C"));

            String resultado = fa.get() + fb.get() + fc.get();
            System.out.println(resultado);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            executor.shutdown();
        }
    }

    private static String tarea(String valor){
        try{
            Thread.sleep(3000);
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        return valor;
    }
}
