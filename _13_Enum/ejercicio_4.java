package _13_Enum;

public class ejercicio_4 {
    static void main() {
        EstadoTarea estado = EstadoTarea.COMPLETADA;
        System.out.println(estado.mensaje());
    }

    public enum EstadoTarea{
        PENDIENTE{
            @Override
            public String mensaje() {
                return "La tarea aún no inicia";
            }
        },
        EN_PROCESO{
            @Override
            public String mensaje() {
                return "La tarea está en ejecución";
            }
        },
        COMPLETADA{
            @Override
            public String mensaje() {
                return "La tarea ya fue completada";
            }
        };

        public abstract String mensaje();
    }

}
