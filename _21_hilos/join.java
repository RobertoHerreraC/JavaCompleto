package _21_hilos;

public class join {
    static void main() throws InterruptedException {
        Thread hilo = new Thread(()->{
            System.out.println("Procesar tarea...");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        });
        hilo.start();
        hilo.join();
        System.out.println("Proceso finalizado");
    }
}
