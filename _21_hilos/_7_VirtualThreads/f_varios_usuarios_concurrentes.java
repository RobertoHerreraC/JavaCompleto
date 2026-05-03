package _21_hilos._7_VirtualThreads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f_varios_usuarios_concurrentes {
    static void main() {
        List<Integer> ids = List.of(1, 2, 3, 4, 5);

        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
            for(Integer id:ids){
                executor.submit(()-> procesarUsuario(id));
            }
        }
    }

    private static void procesarUsuario(Integer id){
        String usuario = consultarUsuario(id);
        enviarNotificacion(usuario);
    }

    private static String consultarUsuario(Integer id){
        dormir(1000);
        return "Usuario-"+id;
    }

    private static void enviarNotificacion(String usuario){
        dormir(3000);
        System.out.println("Notificacion enviada a: "+usuario);
    }

    private static void dormir(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
