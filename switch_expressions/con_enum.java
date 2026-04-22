package switch_expressions;

public class con_enum {
    static void main() {
        EstadoTarea estado = EstadoTarea.EN_PROCESO;
        String mensaje = switch(estado){
          case PENDIENTE -> "La tarea aun no inicia";
          case EN_PROCESO -> "La tarea esta en ejecucion";
          case COMPLETADA -> "La tarea termino correctamente";
        };
        System.out.println(mensaje);
    }
    enum EstadoTarea{
        PENDIENTE,
        EN_PROCESO,
        COMPLETADA
    }
}
