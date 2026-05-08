package _28_Concurrencia_avanzada;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class _g_ReentrantReadWriteLock {
    static void main() throws InterruptedException {
        Cache cache = new Cache();
        cache.escribir("config","v1");

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(()-> cache.escribir("config","v2"));

        for (int i = 0;i<5;i++){
            executor.submit(()->{
               System.out.println("Leyendo: " + cache.leer("config"));
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}

class Cache{
    private final Map<String, String> datos = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public String leer(String clave){
        lock.readLock().lock();
        try{
            return datos.get(clave);
        }finally{
            lock.readLock().unlock();
        }
    }

    public void escribir(String clave, String valor){
        lock.writeLock().lock();
        try{
            datos.put(clave, valor);
        }finally{
            lock.writeLock().unlock();
        }
    }
}