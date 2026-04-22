package Proyectos.SistemaNotificacionYTareas.app;

import Proyectos.SistemaNotificacionYTareas.app.controller.TaskController;
import Proyectos.SistemaNotificacionYTareas.app.model.Priority;
import Proyectos.SistemaNotificacionYTareas.app.repository.TaskRepository;
import Proyectos.SistemaNotificacionYTareas.app.service.ExportService;
import Proyectos.SistemaNotificacionYTareas.app.service.NotificationService;
import Proyectos.SistemaNotificacionYTareas.app.service.TaskService;

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
