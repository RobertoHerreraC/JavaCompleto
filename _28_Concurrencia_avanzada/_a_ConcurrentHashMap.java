package _28_Concurrencia_avanzada;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _a_ConcurrentHashMap {
    static void main() throws Exception {
        ConcurrentHashMap<String, Integer> contador  = new ConcurrentHashMap<>();
        List<String> palabras = List.of("java", "spring", "java", "docker", "java",
                "spring", "sql","docker","java");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(String palabra : palabras){
            executor.submit(() -> {
                contador.compute(palabra,(k,v)->v==null? 1 : v+1);
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(contador);
    }
}
