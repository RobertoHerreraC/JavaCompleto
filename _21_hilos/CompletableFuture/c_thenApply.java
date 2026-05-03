package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class c_thenApply {
    static void main() {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(()-> "Roberto")
                .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }
}
