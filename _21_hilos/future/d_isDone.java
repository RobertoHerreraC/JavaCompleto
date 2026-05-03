package _21_hilos.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class d_isDone {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<String> future = executor.submit(()->{
                Thread.sleep(2000);
                return "OK";
            });

            System.out.println("Termino?:"+future.isDone());
            String resultado = future.get();

            System.out.println("Resultado: "+resultado);
            System.out.println("Termino?: "+future.isDone());
        }catch(Exception e){
            System.out.println("Error: "+e);
        }finally{
            executor.shutdown();
        }
    }
}
