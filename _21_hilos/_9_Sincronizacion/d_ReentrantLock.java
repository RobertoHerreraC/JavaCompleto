package _21_hilos._9_Sincronizacion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d_ReentrantLock {
    static void main() throws InterruptedException {
        Contador2 contador = new Contador2();
        Thread h1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) contador.incrementar();
        });

        Thread h2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) contador.incrementar();
        });

        h1.start();
        h2.start();

        h1.join();
        h2.join();
        System.out.println("Contador 1: " + contador.getValor());
    }
}

class Contador2 {
    private int valor = 0;
    private final Lock lock = new ReentrantLock();

    public void incrementar(){
        lock.lock();
        try{
            valor++;
        }finally{
            lock.unlock();
        }
    }

    public int getValor(){
        lock.lock();
        try {
            return valor;
        }finally {
            lock.unlock();
        }
    }
}
