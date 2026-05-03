package _21_hilos;

public class run_start {
    static void main() {
        Thread hilo = new Thread(()->{
            System.out.println("Ejecutando en: "+Thread.currentThread().getName());
        });

        hilo.run();
        hilo.start();
    }
}
