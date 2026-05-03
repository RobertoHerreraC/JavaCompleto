package _21_hilos._7_VirtualThreads;

import java.util.ArrayList;
import java.util.List;

public class c_muchos_virtual_threads {
    static void main()  throws InterruptedException{
        List<Thread> threads = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int id = i;
            Thread vt = Thread.startVirtualThread(()->{
               dormir(5000);
               System.out.println("Virtual thread terminado: "+id);
            });
            threads.add(vt);
        }
        System.out.println("Antes de ejecutar hilos");
        for(Thread t : threads) {
            t.join();
        }
        System.out.println("Todos terminaron");
    }

    private static void dormir(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
