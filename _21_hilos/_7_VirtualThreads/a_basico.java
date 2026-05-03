package _21_hilos._7_VirtualThreads;

public class a_basico {
    static void main() throws InterruptedException {
        Thread vt = Thread.startVirtualThread(()->{
            System.out.println("Hola desde virtual thread");
        });

        vt.join();
    }
}
