package _21_hilos.executerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class secuencia_paralelo {
    static void main() {
        ejecutarSecuencial();
        ejecutarParalelo();
    }

    private static String tareaLenta(String nombre){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return "Tarea: "+ nombre + " terminada";
    }

    private static void ejecutarParalelo(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        long inicio = System.currentTimeMillis();
        try{
            Future<String> fa = executor.submit(()->tareaLenta("A"));
            Future<String> fb = executor.submit(()->tareaLenta("B"));
            Future<String> fc = executor.submit(()->tareaLenta("C"));

            fa.get();
            fb.get();
            fc.get();
            long fim = System.currentTimeMillis();
            System.out.println("Parelelo: "+(fim-inicio));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            executor.shutdown();
        }
    }

    private static void ejecutarSecuencial(){
        long inicio = System.currentTimeMillis();
        tareaLenta("A");
        tareaLenta("B");
        tareaLenta("C");

        long fin = System.currentTimeMillis();
        System.out.println("Secuencial: "+(fin - inicio));

    }
}
