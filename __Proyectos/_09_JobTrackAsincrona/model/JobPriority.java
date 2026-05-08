package __Proyectos._09_JobTrackAsincrona.model;

public enum JobPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    CRITICAL(4);

    private final int level;

    JobPriority(int level){
        this.level = level;
    }

    public int level(){
        return level;
    }

    public String descrption(){
        return switch(this){
          case LOW -> "Baja";
          case MEDIUM -> "Media";
          case HIGH -> "Alta";
          case CRITICAL -> "Critica";
        };
    }
}
