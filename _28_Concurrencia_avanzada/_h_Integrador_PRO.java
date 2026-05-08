package _28_Concurrencia_avanzada;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _h_Integrador_PRO {
    static void main() throws InterruptedException{
        BackendService service = new BackendService();

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i= 1; i<=10;i++){
            int id = i%3;
            int req = i;
            executor.submit(()->{
               String usuario = service.obtenerUsuario(id,"REQ-"+req);
               System.out.println("Resultado: "+usuario);
            });
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Total request: "+ service.getTotalRequests());
    }
}

class BackendService {
    private final ConcurrentHashMap<Integer,String> cache = new ConcurrentHashMap<>();
    private final AtomicInteger totalRequests = new AtomicInteger(0);
    private final Semaphore apiLimit = new Semaphore(2);
    private static final ThreadLocal<String> requestId = new ThreadLocal<>();

    public String obtenerUsuario(int id, String reqId){
        try{
            requestId.set(reqId);
            totalRequests.incrementAndGet();
            return cache.computeIfAbsent(id,this::consultarApiExterna);
        }finally {
            requestId.remove();
        }
    }

    private String consultarApiExterna(int id){
        try{
            apiLimit.acquire();
            System.out.println("Request "+requestId.get() +
                    " consultando API externa para id="+id);
            Thread.sleep(1000);
            return "Usuario-"+id;
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException("Consulta interrumpida",e);
        }finally{
            apiLimit.release();
        }
    }

    public int getTotalRequests(){
        return totalRequests.get();
    }

}