package __Proyectos.GestionTareas.src;

import __Proyectos.GestionTareas.src.controller.TareaController;

public class Main {
    static void main() {
        TareaController controller= new TareaController();
        controller.crearTarea(1,"Aprender Java");
        controller.crearTarea(2,"Estudiar spring");
        controller.crearTarea(3,"Duplicado");
        controller.listarTareas();
        controller.completarTarea(1);
        controller.eliminarTarea(2);
        System.out.println("Tarea completadas");
        controller.listarCompletadas();
        controller.actualizar(1, "Aprendi Java");
        System.out.println("Tarea actualizada");
        controller.listarTareas();
    }
}
