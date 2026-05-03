package _21_hilos._9_Sincronizacion;

public class a_race_condition {
    static void main() throws InterruptedException {
        Contador contador = new Contador();
        Thread h1 = new Thread(()->{
            for(int i=0;i<1000;i++) contador.incrementar();
        });
        Thread h2 = new Thread(()->{
            for(int i=0;i<1000;i++) contador.incrementar();
        });

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Valor final:"+contador.getValor());
    }
}

class Contador {
    private int valor = 0;
    public void incrementar(){
        valor++;
    }

    public int getValor(){
        return valor;
    }
}
