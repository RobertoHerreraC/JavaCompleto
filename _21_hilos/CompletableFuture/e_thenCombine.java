package _21_hilos.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class e_thenCombine {
    static void main() {
        CompletableFuture<String> nombreFuture = CompletableFuture.supplyAsync(()->{
            dormir(1000);
            return "Roberto";
        });

        CompletableFuture<Double> deudaFuture = CompletableFuture.supplyAsync(()->{
           dormir(5000);
           return 1500.75;
        });

        CompletableFuture<String> resumenFuture = nombreFuture.thenCombine(
          deudaFuture,
                (nombre,deuda)-> "Usuario: "+nombre+", deuda: "+deuda
        );

        System.out.println(resumenFuture.join());
    }


    public static void dormir(long ms)
    {
        try{
            Thread.sleep(ms);
        }catch(InterruptedException e){
            System.out.println("Interrupted: "+e.getMessage());
        }
    }
}
