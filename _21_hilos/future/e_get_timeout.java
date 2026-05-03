package _21_hilos.future;

import java.util.concurrent.*;

public class e_get_timeout {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<String> future = executor.submit(()->{
                Thread.sleep(5000);
                return "Resultado lento";
            });

            String resultado = future.get(2, TimeUnit.SECONDS);
            System.out.println(resultado);

        }catch(TimeoutException e){
            System.out.println("Error: la tarea tardo demasiado");
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }finally{
            executor.shutdown();
        }
    }
}
