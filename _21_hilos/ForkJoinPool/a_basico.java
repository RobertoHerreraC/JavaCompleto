package _21_hilos.ForkJoinPool;

import java.util.concurrent.ForkJoinPool;

public class a_basico {
    static void main() {
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(()->{
            System.out.println("Ejecutando: "+Thread.currentThread().getName());
        }).join();

        pool.shutdown();
    }
}
