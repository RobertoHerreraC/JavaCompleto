package _27_Colecciones_avanzadas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _h_Mini_sistema_backend_real {
    static void main() {
        Map<Integer,Tarea> tareas = new HashMap<Integer,Tarea>();

        tareas.put(1, new Tarea(1, "Estudiar Java"));
        tareas.put(2, new Tarea(2, "Hacer ejercicios"));

        tareas.get(1).completada = true;

        List<Tarea> completadas = tareas.values().stream()
                .filter(t -> t.completada)
                .toList();

        completadas.forEach(t -> System.out.println(t.titulo));
    }
}

class Tarea{
    int id;
    String titulo;
    boolean completada;
    Tarea(int id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }
}