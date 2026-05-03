package _21_hilos._7_VirtualThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d_con_ExecutorService {
    static void main() {
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            for(int i = 1; i <= 5; i++){
                int id = 1;
                executor.submit(()->{
                    System.out.println("Tarea " +id+" en "+ Thread.currentThread());
                });
            }
        }
    }
}
