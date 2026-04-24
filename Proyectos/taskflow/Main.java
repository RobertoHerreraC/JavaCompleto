package Proyectos.taskflow;

import Proyectos.taskflow.controller.TaskController;
import Proyectos.taskflow.model.Priority;
import Proyectos.taskflow.model.TaskStatus;
import Proyectos.taskflow.repository.TaskRepository;
import Proyectos.taskflow.service.ExportService;
import Proyectos.taskflow.service.NotificationService;
import Proyectos.taskflow.service.TaskService;

public class Main {
    static void main() {
        TaskRepository taskRepository = new TaskRepository();
        NotificationService notificationService = new NotificationService();
        ExportService exportService = new ExportService();

        TaskService taskService = new TaskService(taskRepository, notificationService);
        TaskController controller = new TaskController(taskService, exportService);

        controller.createTask(
                "Repasar Streams",
                "Practicar map, filter y grupingBy",
                Priority.HIGH,
                "STANDARD"
        );

        controller.createTask(
                "Corregir bug critico",
                "Revisar error en cálculo de pagos",
                Priority.CRITICAL,
                "URGENT"
        );

        controller.createTask(
                "Esperando acceso a BD",
                "No se puede continuar hasta recibir credenciales",
                Priority.MEDIUM,
                "BLOCKED"
        );

        controller.listAll();

        controller.startTask(1L);
        controller.addComment(1L,"Roberto", "Ya avance con la primera parte");
        controller.completeTask(1L);

        controller.notifyByEmail(2L,"soporte@empresa.com","Alerta critica");

        controller.listBtStatus(TaskStatus.COMPLETED);

        controller.exportAll();

    }
}
