package _27_Colecciones_avanzadas;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _f_ConcurrentHashMap {
    static void main() throws Exception{
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
               map.compute("contador",(k,v)-> v==null?1:v+1);
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(map.get("contador"));
    }
}
