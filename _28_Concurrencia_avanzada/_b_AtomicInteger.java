package _28_Concurrencia_avanzada;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class _b_AtomicInteger {
    static void main() throws Exception {
        AtomicInteger contador = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                contador.incrementAndGet();
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("Total: "+contador.get());
    }
}
