package Proyectos.taskflow.model;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    CRITICAL(4);
    private final int level;
    Priority(int level){
        this.level = level;
    }

    public int level(){
        return level;
    }

    public String displayName(){
        return switch(this){
          case LOW -> "Baja";
          case MEDIUM -> "Media";
          case HIGH -> "Alta";
          case CRITICAL -> "Critica";
        };
    }
}
