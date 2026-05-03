package __Proyectos.GestionTareas.src.model;

import java.time.LocalDate;

public class Tarea {
    public int id;
    public String titulo;
    public boolean completado;
    LocalDate fechaCreacion;

    public Tarea(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
        this.completado = false;
        this.fechaCreacion = LocalDate.now();
    }

}
