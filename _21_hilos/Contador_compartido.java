package _21_hilos;

public class Contador_compartido {
    static void main() throws InterruptedException {
        Contador contador = new Contador();
        Thread h1 = new  Thread(()->{
            for(int i=1;i<=1000;i++) {
                contador.incrementar();
            }
        });

        Thread h2 = new  Thread(()->{
           for(int i=1;i<=1000;i++) {
               contador.incrementar();
           }
        });

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println(contador.getValor());
    }
}

class Contador{
    private int valor = 0;
    public synchronized void incrementar(){
        valor++;
    }

    public int getValor(){
        return valor;
    }
}
