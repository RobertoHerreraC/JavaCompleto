package _21_hilos._9_Sincronizacion;

public class f_deadlock_correccion {
    static void main() throws InterruptedException {
        TransferenciaService service = new TransferenciaService();
        Thread h1 = new Thread(service::transferirA_B);
        Thread h2 = new Thread(service::transferirB_A);

        h1.start();
        h2.start();

        h1.join();
        h2.join();
    }
}

class TransferenciaService{
    private final Object lockCuentaA = new Object();
    private final Object lockCuentaB = new Object();

    public void transferirA_B(){
        synchronized(lockCuentaA){
            synchronized (lockCuentaB){
                System.out.println("Transferencia A->B");
            }
        }
    }

    public void transferirB_A(){
        synchronized(lockCuentaA){
            synchronized (lockCuentaB){
                System.out.println("Transferencia B->A");
            }
        }
    }
}
