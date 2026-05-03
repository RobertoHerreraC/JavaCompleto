package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class f_exceptionally {
    static void main() {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(()->{
                    if(true){
                        throw new RuntimeException("Error externo");
                    }
                    return "OK";
                })
                .exceptionally(error-> "Servicios no disponible");

        System.out.println(future.join());
    }
}
