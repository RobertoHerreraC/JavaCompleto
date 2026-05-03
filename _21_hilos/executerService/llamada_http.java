package _21_hilos.executerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class llamada_http {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try{
            Future<String> clienteFuture = executor.submit(()->consultarCliente());
            Future<Double> deudaFuturre =  executor.submit(()->consultarDeuda());
            Future<Integer> scoreFuture = executor.submit(()->consultarScore());

            String cliente = clienteFuture.get();
            Double deuda = deudaFuturre.get();
            Integer score = scoreFuture.get();
            String resumen = """
                    Cliente: %s
                    Deuda: %.2f
                    Score: %d
                    """.formatted(cliente, deuda, score);

            System.out.println(resumen);

        }catch(Exception e){
            System.err.println(e.getMessage());
        }finally{
            executor.shutdown();
        }


    }
    private static String consultarCliente(){
        dormir();
        return "Roberto Herrera";
    }

    private static Double consultarDeuda(){
        dormir();
        return 1500.75;
    }

    private static Integer consultarScore(){
        dormir();
        return 720;
    }

    private static void dormir(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
