package _21_hilos.CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class d_thenAccept {
    static void main() {
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(()-> List.of(10.0, 20.0, 30.0))
                .thenApply(precios -> precios.stream()
                        .mapToDouble(Double::doubleValue)
                        .sum()
                )
                .thenAccept(total -> System.out.println("Total: "+total));

        future.join();
    }
}
