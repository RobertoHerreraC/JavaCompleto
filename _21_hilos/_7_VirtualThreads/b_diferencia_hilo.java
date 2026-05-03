package _21_hilos._7_VirtualThreads;

public class b_diferencia_hilo {
    static void main() throws InterruptedException{
        Thread platformThread = Thread.ofPlatform()
                .name("platform-thread")
                .start(()->{
                    System.out.println("Tradicional: "+Thread.currentThread().getName());
                });

        Thread virtualThread = Thread.ofVirtual()
                .name("virtual-thread")
                .start(()->{
                    System.out.println("Virtual: "+Thread.currentThread().getName());
                });

        platformThread.join();
        virtualThread.join();
    }
}
