package __Proyectos.SistemaNotificacionYTareas.app.service;

import __Proyectos.SistemaNotificacionYTareas.app.dto.TaskResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class ExportService {
    private final ObjectMapper mapper = new ObjectMapper().
            findAndRegisterModules().
            enable(SerializationFeature.INDENT_OUTPUT);

    public String exportTasks(List<TaskResponseDTO> tasks){
        try{
            return mapper.writeValueAsString(tasks);
        }catch(Exception e){
            throw new RuntimeException("Error exportando tareas: "+e);
        }
    }

    public String exportSummary(List<TaskResponseDTO> tasks){
        return """
                ========= RESUME DE TAREAS =========
                Total de tareas: %d
                ====================================
                """.formatted(tasks.size());
    }
}
