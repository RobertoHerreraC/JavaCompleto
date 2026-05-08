package _28_Concurrencia_avanzada;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _d_ThreadLocal {
    private static final ThreadLocal<String> requestId = new ThreadLocal<>();
    static void main() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i < 4; i++) {
            int id = i;
            executor.submit(()->{
               try{
                   requestId.set("REQ-"+id);
                   procesar();
               }finally {
                   requestId.remove();
               }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

    }

    private static void procesar(){
        System.out.println(Thread.currentThread().getName()+ " procesando "+requestId.get());
    }
}
