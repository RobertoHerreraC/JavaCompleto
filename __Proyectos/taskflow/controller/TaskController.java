package __Proyectos.taskflow.controller;


import __Proyectos.taskflow.dto.CommentDTO;
import __Proyectos.taskflow.dto.NotificationResultDTO;
import __Proyectos.taskflow.dto.TaskCreateDTO;
import __Proyectos.taskflow.dto.TaskResponseDTO;
import __Proyectos.taskflow.model.EmailNotification;
import __Proyectos.taskflow.model.Priority;
import __Proyectos.taskflow.model.TaskStatus;
import __Proyectos.taskflow.service.ExportService;
import __Proyectos.taskflow.service.TaskService;

public class TaskController {
    private final TaskService taskService;
    private final ExportService exportService;

    public TaskController(TaskService taskService, ExportService exportService) {
        this.taskService = taskService;
        this.exportService = exportService;
    }

    public void createTask(String title, String description, Priority priority, String type){
        TaskResponseDTO response = taskService.create(
                new TaskCreateDTO(title, description, priority, type)
        );
        System.out.println("Tarea creada: "+ response);
    }
    public void startTask(Long id){
        System.out.println("Tarea iniciada: "+ taskService.start(id));
    }

    public void completeTask(Long id){
        System.out.println("Tarea finalizada: "+ taskService.complete(id));
    }

    public  void addComment(Long id, String author, String message){
        System.out.println("Comentario agregado: "+taskService.addComment(id,new CommentDTO(author,message)));
    }

    public void listAll(){
        System.out.println("=== LISTADO DE TAREAS ===");
        taskService.findAll().forEach(System.out::println);
    }

    public void listBtStatus(TaskStatus status){
        System.out.println("=== LISTADO POR ESTADO ===");
        taskService.findByStatus(status).forEach(System.out::println);
    }

    public void notifyByEmail(Long id, String recipient, String subject){
        String message = """
                Hola,
                se ha generado una alerta sobre una tarea registrada en TaskFlow.
                Revisa el sistema para más información
                """;
        NotificationResultDTO response = taskService.notifyTask(
                id,
                new EmailNotification(recipient,subject,message)
        );
        System.out.println("Notificacion enviada: "+response);
    }

    public void exportAll(){
        var tasks = taskService.findAll();
        var summary = taskService.summaryByStatus();

        System.out.println(exportService.buildSummary(summary));
        System.out.println(exportService.exportTask(tasks));
    }
}
