package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class a_runAsync {
    static void main() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            System.out.println("Ejecutando en: "+Thread.currentThread().getName());
        });

        future.join();

        System.out.println("Ejecutando en: "+Thread.currentThread().getName());
        System.out.println("Main terminado");
    }
}
