package _28_Concurrencia_avanzada;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _f_CountDownLatch {
    static void main() throws InterruptedException{
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(()-> iniciarServicio("BD", latch));
        executor.submit(()-> iniciarServicio("Cache", latch));
        executor.submit(()-> iniciarServicio("Mensajeria", latch));

        System.out.println("Esperando servicios...");
        latch.await();
        System.out.println("Todos los servicios iniciaron");

        executor.shutdown();
    }

    private static void iniciarServicio(String nombre, CountDownLatch latch){
        try{
            Thread.sleep(10000);
            System.out.println(nombre + " iniciado");
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally{
            latch.countDown();
        }
    }
}
