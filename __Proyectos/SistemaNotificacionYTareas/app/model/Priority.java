package __Proyectos.SistemaNotificacionYTareas.app.model;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int level;
    Priority(int level){
        this.level = level;
    }

    public int level(){
        return level;
    }

    public String displayName(){
        return switch(this)
        {
            case LOW-> "Baja";
            case MEDIUM->"Media";
            case HIGH->"Alta";
        };
    }
}
