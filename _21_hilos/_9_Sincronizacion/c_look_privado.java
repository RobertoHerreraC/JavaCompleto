package _21_hilos._9_Sincronizacion;

public class c_look_privado {
    static void main() throws InterruptedException {
        Inventario inventario = new Inventario(10);
        Thread h1 = new Thread(()->{
            System.out.println("Venta 1: "+inventario.vender(7));
        });

        Thread h2 =new Thread(()->{
           System.out.println("Venta 2: "+inventario.vender(7));
        });

        h1.start();
        h2.start();

        h1.join();
        h2.join();
    }
}

class Inventario{
    private int stock;
    private final Object lock = new Object();

    public Inventario(int stock) {
        this.stock = stock;
    }

    public boolean vender(int cantidad){
        synchronized(lock){
            if(cantidad<=stock){
                stock -= cantidad;
                return true;
            }
        }
        return false;
    }

    public int getStock(){
        synchronized(lock){
            return stock;
        }
    }
}
