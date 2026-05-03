package __Proyectos.GestionTareas.src.controller;

import __Proyectos.GestionTareas.src.service.TareaService;

public class TareaController {
    private TareaService service = new TareaService();

    public void crearTarea(int id, String titulo){
        try{
            service.crear(id, titulo);
            System.out.println("Tarea creado exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarTareas(){
        service.listar().forEach(System.out::println);
    }

    public void listarCompletadas(){
        service.listarCompletadas().forEach(System.out::println);
    }

    public void completarTarea(int id){
        try{
            service.completar(id);
            System.out.println("Tarea completo exitosamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void actualizar(int id, String nuevoTitulo){
        try{
            service.actualizarTitulo(id, nuevoTitulo);
            System.out.println("Tarea actualizado exitosamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void eliminarTarea(int id){
        try{
            service.eliminar(id);
            System.out.println("Tarea eliminado exitosamente");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
