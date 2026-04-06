package Proyectos.GestionTareas.src.service;

import Proyectos.GestionTareas.src.dto.TareaDTO;
import Proyectos.GestionTareas.src.exception.RecursoNoEncontradoException;
import Proyectos.GestionTareas.src.exception.ValidacionException;
import Proyectos.GestionTareas.src.model.Tarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TareaService {
    private Map<Integer,Tarea> tareas = new HashMap<>();

    public void crear(int id, String titulo) throws ValidacionException {
        if(titulo==null || titulo.isEmpty()) throw new ValidacionException("Titulo vacio");

        if(tareas.containsKey(id)) throw new ValidacionException("Tarea ya existe");

        tareas.put(id,new Tarea(id,titulo));
    }

    public List<TareaDTO> listar(){
        List<TareaDTO> lista = new ArrayList<>();
        for(Tarea t: tareas.values()){
            lista.add(toDTO(t));
        }
        return lista;
    }

    public Tarea buscar(int id)throws RecursoNoEncontradoException{
        Tarea t = tareas.get(id);
        if(t==null) throw new RecursoNoEncontradoException("Tarea no encontrada");
        return t;
        //        return tareas.stream()
//                .filter(t->t.id==id)
//                .findFirst()
//                .orElseThrow(()->new RecursoNoEncontradoException("No existe tarea"));
    }

    public void completar(int id)throws RecursoNoEncontradoException{
        buscar(id).completado =true;
        //        Tarea t = buscar(id);
//        t.completado = true;
    }

    public void eliminar(int id)throws RecursoNoEncontradoException{
        buscar(id);
        tareas.remove(id);
        //        Tarea t = buscar(id);
//        tareas.remove(t);
    }

    public void actualizarTitulo(int id, String nuevoTitulo) throws ValidacionException,  RecursoNoEncontradoException{
        if(nuevoTitulo==null || nuevoTitulo.isEmpty()) throw new ValidacionException("Titulo vacio");

        buscar(id).titulo = nuevoTitulo;

    }

    private TareaDTO toDTO(Tarea t){
        return new TareaDTO(t.id, t.titulo, t.completado);
    }

    public List<TareaDTO> listarCompletadas(){
        List<TareaDTO> lista = new ArrayList<>();
        for(Tarea t: tareas.values()){
            if(t.completado) lista.add(toDTO(t));
        }
        return lista;
    }
}
