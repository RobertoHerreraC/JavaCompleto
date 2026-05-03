package _21_hilos.executerService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class varias_tareas_pool_fijo {
    static void main() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int j=0;j<6;j++){
            int numeroTarea= j;
            executor.submit(()->{
                System.out.println(
                        "Tarea "+numeroTarea +
                                " ejecutada por "+Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
