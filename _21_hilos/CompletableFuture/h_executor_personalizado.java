package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class h_executor_personalizado {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try{
            CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
                return "Ejecutandose es: "+Thread.currentThread().getName();
            },executor);
            System.out.println(future.join());
        }finally {
            executor.shutdown();
        }
    }
}
