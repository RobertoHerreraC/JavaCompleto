package _21_hilos.runnable_callable;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class runnable_callable {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable guardarLog = ()->{
            System.out.println("Guardando log...");
        };

        Callable<Double> calcularTotal = ()->{
            List<Double> precios = List.of(10.00,20.0,30.0);
            return precios.stream().mapToDouble(Double::doubleValue).sum();
        };

        try{
            Future<?> logFuture = executor.submit(guardarLog);
            Future<Double> totalFuture = executor.submit(calcularTotal);

            logFuture.get();
            Double total = totalFuture.get();
            System.out.println(total);
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }finally{
            executor.shutdown();
        }
    }
}
