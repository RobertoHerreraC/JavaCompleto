package _24_Fallback_observabilidad;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class h_mini_backend_integrador {
    static void main() {
        ResumenService resumenService = new ResumenService();
        ResumenFinanciero resumen = resumenService.obtenerResumen(1);
        System.out.println(resumen);
    }
}

class ResumenService{
    private static final LoggerFake2 LOGGER = new LoggerFake2(ResumenService.class);

    private String consultarNombre(int usuarioId){
        return "Roberto Herrera";
    }

    private double consultarDeuda(int usuarioId){
        throw new RuntimeException("Timeout deuda externa");
    }

    private int consultarScore(int usuarioId){
        throw new RuntimeException("Timeout score no responde");
    }

    public ResumenFinanciero obtenerResumen(int usuarioId){
        LOGGER.info("Iniciando resumen financiero usuarioId="+usuarioId);
        CompletableFuture<String> nombreFuture = CompletableFuture
                .supplyAsync(()->consultarNombre(usuarioId));

        CompletableFuture<String> deudaFuture = CompletableFuture
                .supplyAsync(()->consultarDeuda(usuarioId))
                .thenApply("Deuda: %.2f"::formatted)
                .exceptionally(error->{
                    LOGGER.error("Fallo consulta de deuda usuarioId="+usuarioId,error);
                    return "DEUDA_NO_DISPONIBLE";
                });

        CompletableFuture<Integer> scoreFuture = CompletableFuture
                .supplyAsync(()->consultarScore(usuarioId))
                .exceptionally(error->{
                    LOGGER.error("Fallo consulta de score usuarioId="+usuarioId,error);
                    return 0;
                });

        String nombre = nombreFuture.join();
        String deuda = deudaFuture.join();
        int score = scoreFuture.join();

        LOGGER.debug("Datos obtenidos nombre="+nombre + ", deuda="+deuda+", score="+score);
        LOGGER.info("Financiero resumen financiero usuarioId="+usuarioId);
        return new ResumenFinanciero(nombre, deuda, score);
    }

}

class LoggerFake2{
    private final String clase;
    public LoggerFake2(Class<?> clase){
        this.clase = clase.getSimpleName();
    }

    public void info(String mensaje){
        log("INFO",mensaje);
    }

    public void debug(String mensaje){
        log("DEBUG",mensaje);
    }

    public void error(String mensaje, Throwable e){
        log("ERROR",mensaje + " | causa: "+ e.getMessage());
    }

    public void log(String nivel, String mensaje){
        System.out.println(LocalDateTime.now()+" ["+nivel+"] "+clase+" - "+mensaje);
    }
}

record ResumenFinanciero(String nombre, String deuda, int score){}