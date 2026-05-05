package _24_Fallback_observabilidad;

import java.time.LocalDateTime;

public class e_logger_basico {
    private static final LoggerFake LOGGER = new LoggerFake(e_logger_basico.class);
    static void main() {
        LOGGER.info("Aplicacion iniciada");
        LOGGER.debug("Variable x=100");

        try{
            throw new RuntimeException("Fallo simulado");
        }catch (RuntimeException e){
            LOGGER.error("Ocurrio un error", e);
        }
    }
}

class LoggerFake{
    private final String clase;
    public LoggerFake(Class<?> clazz) {
        this.clase = clazz.getSimpleName();
    }

    public void info(String mensaje){
        log("INFO",mensaje);
    }

    public void debug(String mensaje){
        log("DEBUG",mensaje);
    }

    public void error(String mensaje, Exception e){
        log("ERROR",mensaje + " | casusa: "+e.getMessage());
    }

    private void log(String nivel, String mensaje){
        System.out.println(LocalDateTime.now()+" ["+nivel+"] "+ clase + " - "+mensaje);
    }
}
