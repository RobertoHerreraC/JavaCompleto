package _21_hilos._9_Sincronizacion;

public class b_synchronized {
    static void main() throws InterruptedException {
        Contador1 contador = new Contador1();

        Thread h1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) contador.incrementar();
        });

        Thread h2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) contador.incrementar();
        });

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Valor final: " + contador.getValor());
    }
}

class Contador1 {
    private int valor = 0;

    public synchronized void incrementar() {
        valor++;
    }

    public synchronized int getValor() {
        return valor;
    }
}
