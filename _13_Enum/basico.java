package _13_Enum;

public class basico {
    static void main() {
        System.out.println(Prioridad.ALTA.getDescripcion());
    }

    public enum Prioridad{
        BAJA("Tarea no urgente"),
        MEDIA("Tarea importante"),
        ALTA("Tarea critica");

        private final String descripcion;

        Prioridad(String descripcion){
            this.descripcion = descripcion;
        }
        public String getDescripcion(){
            return this.descripcion;
        }
    }
}

