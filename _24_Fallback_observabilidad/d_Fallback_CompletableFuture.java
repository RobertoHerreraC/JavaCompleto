package _24_Fallback_observabilidad;

import java.util.concurrent.CompletableFuture;

public class d_Fallback_CompletableFuture {
    static void main() {
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(()->consultarApi())
                .exceptionally( error -> {
                    System.out.println("Error async: "+error.getMessage());
                    return "Respuesta Fallback";
                });

        System.out.println(future.join());
    }

    public static String consultarApi(){
        throw new RuntimeException("API externa caida");
    }
}
