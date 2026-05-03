package _21_hilos.runnable_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class future_executorService {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = ()->{
          Thread.sleep(1000);
          return "Tarea completada";
        };

        try{
            Future<String> future = executor.submit(tarea);
            System.out.println("Esperando resultado.");
            String resultado = future.get();
            System.out.println("Resultado: "+resultado);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            executor.shutdown();
        }
    }
}
