package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class g_allOf {
    static void main() {
        CompletableFuture<String> clienteFuture = CompletableFuture.supplyAsync(()->{
            dormir(1000);
            return "Roberto Herrera";
        });

        CompletableFuture<Double> deudaFuture = CompletableFuture.supplyAsync(()->{
            dormir(1000);
            return 2500.5;
        });

        CompletableFuture<Integer> scoreFuture = CompletableFuture.supplyAsync(()->{
            dormir(1000);
            return 730;
        });

        CompletableFuture<Void> all= CompletableFuture.allOf(
                clienteFuture,
                deudaFuture,
                scoreFuture
        );

        all.join();
        String resumen = """
                Cliente: %s
                Deuda: %.2f
                Score: %d
                """.formatted(
                        clienteFuture.join(),
                deudaFuture.join(),
                scoreFuture.join()
        );

        System.out.println(resumen);
    }

    public static void dormir(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
