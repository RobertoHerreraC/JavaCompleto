package _21_hilos.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class g_cancelar_tarea {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<?> future = executor.submit(()->{
                while(!Thread.currentThread().isInterrupted()) {
                    System.out.println("Trabajando...");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Catch: Interrupted");
                    }
                }
                System.out.println("Tarea detenida");
            });

            Thread.sleep(1000);
            boolean cancelado = future.cancel(true);
            System.out.println("Cancelacion solicitada: "+cancelado);
            System.out.println("Cancelado?: "+future.isCancelled());

        }catch(Exception e){
            System.out.println("Error: "+e);
        }finally{
            executor.shutdown();
        }
    }
}
