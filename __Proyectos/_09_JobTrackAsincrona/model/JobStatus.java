package __Proyectos._09_JobTrackAsincrona.model;

public enum JobStatus {
    PENDING("Pendiente"),
    PROCESSING("Procesando"),
    COMPLETED("Completado"),
    FAILED("Fallido");

    private final String label;

    JobStatus(String label){
        this.label = label;
    }

    public String label(){
        return label;
    }

    public boolean canProcess(){
        return this == PENDING || this == FAILED;
    }
}
