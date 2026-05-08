package _28_Concurrencia_avanzada;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class _e_Semphore {
    static void main() throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i < 10; i++) {
            int usuario = i;
            executor.submit(()->{
                try{
                    semaphore.acquire();
                    System.out.println("Usuario: "+usuario+ " usando recurso");
                    Thread.sleep(3000);
                    System.out.println("Usuario: "+usuario + " liberando recurso");
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }finally{
                    semaphore.release();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
    }
}
