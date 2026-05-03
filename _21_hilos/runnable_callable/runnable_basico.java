package _21_hilos.runnable_callable;

public class runnable_basico {
    static void main() {
        //no crea hilo
        Runnable tarea = ()->{
            System.out.println("Procesando tarea sin retorno");
        };
        tarea.run();
    }
}
