package _21_hilos._7_VirtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class e_simular_llamadas_concurrentes {
    static void main() throws Exception {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            Future<String> clienteFuture = executor.submit(()-> consultaCliente());
            Future<Double> deudaFuture = executor.submit(()-> consultarDeuda());
            Future<Integer> scoreFuture = executor.submit(()-> consultarScore());

            String cliente = clienteFuture.get();
            Double deuda = deudaFuture.get();
            Integer score = scoreFuture.get();

            String resumen= """
                    Cliente: %s
                    Deuda: %.2f
                    Socre: %d
                    """.formatted(cliente, deuda, score);

            System.out.println(resumen);
        }
    }

    private static void dormir(int ms) {
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private static String consultaCliente(){
        dormir(5000);
        return "Roberto Herrera";
    }

    private static Double consultarDeuda(){
        dormir(6000);
        return 1536.36;
    }

    private static Integer consultarScore(){
        dormir(2000);
        return 720;
    }
}
