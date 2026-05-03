package __Proyectos.SistemaNotificacionYTareas.app;

import __Proyectos.SistemaNotificacionYTareas.app.controller.TaskController;
import __Proyectos.SistemaNotificacionYTareas.app.model.Priority;
import __Proyectos.SistemaNotificacionYTareas.app.repository.TaskRepository;
import __Proyectos.SistemaNotificacionYTareas.app.service.ExportService;
import __Proyectos.SistemaNotificacionYTareas.app.service.NotificationService;
import __Proyectos.SistemaNotificacionYTareas.app.service.TaskService;

public class Main {
    static void main() {
        TaskRepository taskRepository = new TaskRepository();
        NotificationService notificationService = new NotificationService();
        ExportService exportService = new ExportService();

        TaskService taskService = new TaskService(taskRepository, notificationService);
        TaskController taskController = new TaskController(taskService, exportService);

        taskController.createTask(
                "Estudiar Java moderno",
                "Repasar records, sealed classes y streams",
                Priority.HIGH
        );

        taskController.createTask(
                "Practicar arquitectura",
                "Crear mini proyectos estilo backend",
                Priority.MEDIUM
        );


        taskController.listarTasks();

        taskController.completeTask(1L);
        taskController.notifyByEmail(2L,"roberto@gmail.com","Nueva alerta");

        taskController.exportTasks();

    }
}
