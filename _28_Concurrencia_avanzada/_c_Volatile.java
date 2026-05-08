package _28_Concurrencia_avanzada;

public class _c_Volatile {
    private static volatile boolean running = true;
    static void main() throws InterruptedException{
        Thread worker = new Thread(()->{
           while(running){
               System.out.println("Trabajando...");
           }
           System.out.println("Worker detenido");
        });

        worker.start();
        Thread.sleep(2000);
        running= false;

        worker.join();
        System.out.println("Main terminado");
    }
}
