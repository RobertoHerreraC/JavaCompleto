package _21_hilos._9_Sincronizacion;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class e_tryLock {
    static void main() {
        RecursoCompartido recursoCompartido = new RecursoCompartido();
        Thread h1 = new Thread(()-> recursoCompartido.usar("Hilo 1"));
        Thread h2 = new Thread(()-> recursoCompartido.usar("Hilo 2"));

        h1.start();
        h2.start();
    }
}

class RecursoCompartido{
    private final ReentrantLock lock = new ReentrantLock();

    public void usar(String nombre){
        try{
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                System.out.println(nombre + " usando");
                Thread.sleep(8000);
                System.out.println(nombre + " Termino");
            }else{
                System.out.println(nombre + " no puede ser usado");
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
