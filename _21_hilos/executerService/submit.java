package _21_hilos.executerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class submit {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(()->{
            System.out.println("Ejecutando en: "+Thread.currentThread().getName());
        });
        executor.shutdown();
    }
}
