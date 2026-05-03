package _21_hilos.runnable_callable;

public class runnable_thread {
    static void main() {
        Runnable tarea = ()->{
            System.out.println("Ejecutando: "+Thread.currentThread().getName());
        };

        Thread hilo = new Thread(tarea);
        hilo.start();
        System.out.println("Main es : "+Thread.currentThread().getName());
    }
}
