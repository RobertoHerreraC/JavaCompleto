package _21_hilos.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class a1_basico {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<Integer> future = executor.submit(()->{
                return 50+70;
            });

            Integer resultado = future.get();
            System.out.println(resultado);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            executor.shutdown();
        }

    }
}
