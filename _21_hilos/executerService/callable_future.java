package _21_hilos.executerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callable_future {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try{
            Future<Integer> future = executor.submit(()->{
                return 10+20;
            });
            Integer resultado = future.get();

            System.out.println(resultado);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            executor.shutdown();
        }
    }
}
