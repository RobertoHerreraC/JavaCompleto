package _21_hilos.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class f_exception {
    static void main() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try{
            Future<Integer> future = executor.submit(()-> {
                return 10/0;
            });
            Integer resultado = future.get();
            System.out.println(resultado);
        }catch(ExecutionException e){
            System.out.println("La tarea fallo");
            System.out.println("Causa:"+e.getCause());
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
        }finally {

            executor.shutdown();
        }
    }

}
