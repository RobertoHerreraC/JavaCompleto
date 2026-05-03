package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class b_supplyAsync {
    static void main() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            return "Roberto";
        });

        String resultado = future.join();
        System.out.println(resultado);
    }
}
