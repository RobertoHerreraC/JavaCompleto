package Proyectos.taskflow.model;

public enum TaskStatus {
    PENDING{
        @Override
        public String label(){
            return "Pendiente";
        }
    },
    IN_PROGRESS{
        @Override
        public String label(){
            return "En progreso";
        }
    },
    BLOCKED{
        @Override
        public String label(){
            return "Bloqueada";
        }
    },
    COMPLETED{
        @Override
        public String label(){
            return "Completada";
        }
    };

    public abstract String label();
}
