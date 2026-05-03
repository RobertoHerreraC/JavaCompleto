package _21_hilos.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class b_get {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<String> future = executor.submit(()->{
                Thread.sleep(3000);
                return "Tarea terminada";
            });
            System.out.println("Antes del get()");
            String result = future.get();
            System.out.println("Despues del get(): "+result);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            executor.shutdown();
        }
    }
}
