package _21_hilos;

public class sleep {
    static void main() {
        Thread hilo = new Thread(()->{
            try{
                System.out.println("Esperando...");
                Thread.sleep(2000);
                System.out.println("Listo despues de 2 segundos.");
            }catch(Exception e){
                System.out.println(e);
            }
        });

        hilo.start();
    }
}
