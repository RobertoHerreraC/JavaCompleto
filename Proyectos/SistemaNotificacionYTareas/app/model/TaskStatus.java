package Proyectos.SistemaNotificacionYTareas.app.model;

public enum TaskStatus {
    PENDING{
        @Override
        public String label(){
            return "Pendiente";
        }
    },
    COMPLETED{
        @Override
        public String label(){
            return "Completado";
        }
    };

    public abstract String label();
}
