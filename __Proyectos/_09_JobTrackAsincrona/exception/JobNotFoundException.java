package __Proyectos._09_JobTrackAsincrona.exception;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(Long id){
        super("Job no encontrado con id: "+id);
    }
}
