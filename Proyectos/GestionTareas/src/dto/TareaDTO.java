package Proyectos.GestionTareas.src.dto;

public class TareaDTO {
    int id;
    String titulo;
    boolean completado;

    public TareaDTO(int id, String titulo, boolean completado){
        this.id=id;
        this.titulo=titulo;
        this.completado=completado;
    }

    @Override
    public String toString(){
        return id+" - "+titulo+" ["+(completado? "✔": "❌")+"]";
    }
}
