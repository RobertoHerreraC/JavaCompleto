package _21_hilos;

public class basico {
    static void main() {
        Thread hilo = new  Thread(()->{
            System.out.println("Hola desde otro hillo");
        });

        hilo.run();
        System.out.println("Hola desde main");
    }
}
