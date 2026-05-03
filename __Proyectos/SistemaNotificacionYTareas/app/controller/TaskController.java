package __Proyectos.SistemaNotificacionYTareas.app.controller;

import __Proyectos.SistemaNotificacionYTareas.app.dto.NotificationResponseDTO;
import __Proyectos.SistemaNotificacionYTareas.app.dto.TaskRequestDTO;
import __Proyectos.SistemaNotificacionYTareas.app.dto.TaskResponseDTO;
import __Proyectos.SistemaNotificacionYTareas.app.model.EmailNotification;
import __Proyectos.SistemaNotificacionYTareas.app.model.Priority;
import __Proyectos.SistemaNotificacionYTareas.app.service.ExportService;
import __Proyectos.SistemaNotificacionYTareas.app.service.TaskService;

public class TaskController {
    private final TaskService taskService;
    private final ExportService exportService;

    public  TaskController(TaskService taskService, ExportService exportService) {
        this.taskService = taskService;
        this.exportService = exportService;
    }

    public void createTask(String title, String description, Priority priority){
        TaskResponseDTO response = taskService.create(new TaskRequestDTO(title,description,priority));
        System.out.println("Tarea creado: "+ response);
    }
    public void completeTask(Long id){
        TaskResponseDTO response = taskService.complete(id);
        System.out.println("Tarea completado: "+ response);
    }

    public void listarTasks(){
        System.out.println("Listado de tareas:");
        taskService.listTasks().forEach(System.out::println);
    }

    public void notifyByEmail(Long id, String recipient, String subject){
        String mesagge = """
                Hola,
                tienes una notificacion asociada a tu tarea.
                Revisa el sistema para mas detalle.
                """;

        NotificationResponseDTO response = taskService.notifuTask(id,new EmailNotification(recipient,subject,mesagge));
        System.out.println("Tarea notificado: "+ response);
    }

    public void exportTasks(){
        var tasks = taskService.listTasks();
        System.out.println(exportService.exportSummary(tasks));
        System.out.println(exportService.exportTasks(tasks));
    }
}
