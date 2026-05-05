package _24_Fallback_observabilidad;

import java.time.LocalDateTime;

public class f_servicio_fallback_logging {
    static void main() {
        DeudaService service = new DeudaService();
        double deuda = service.obtenerDeuda(10);
        System.out.println(deuda);
    }
}

class DeudaService {
    private static final LoggerFake1 LOGGER = new LoggerFake1(DeudaService.class);
    public double obtenerDeuda(int usuarioId){
        try{
            LOGGER.info("Consultando deuda para usuarioId="+usuarioId);
            return consultarApiDeuda(usuarioId);
        }catch (RuntimeException e){
            LOGGER.error("Fallo consulta de deuda. Se usara fallback usuarioId="+usuarioId,e);
            return 0.0;
        }
    }

    private double consultarApiDeuda(int usuarioId){
        throw new RuntimeException("Timeout consultado deuda");
    }
}

class LoggerFake1{
    private final String clase;
    public LoggerFake1(Class<?> clazz){
        this.clase = clazz.getSimpleName();
    }
    public void info(String mensaje){
        log("INFO",mensaje);
    }

    public void debug(String mensaje){
        log("DEBUG",mensaje);
    }

    public void error(String mensaje, Exception e){
        log("ERROR", mensaje + " | causa: "+e.getMessage());
    }

    private void log(String nivel, String mensaje){
        System.out.println(LocalDateTime.now()+" ["+ this.clase + "] " + nivel + " - " + mensaje);
    }
}
