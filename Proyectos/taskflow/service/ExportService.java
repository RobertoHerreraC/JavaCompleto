package Proyectos.taskflow.service;

import Proyectos.taskflow.dto.TaskResponseDTO;
import Proyectos.taskflow.model.TaskStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class ExportService {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .findAndRegisterModules()
            .enable(SerializationFeature.INDENT_OUTPUT);

    public String exportTask(List<TaskResponseDTO> tasks){
        try{
            return objectMapper.writeValueAsString(tasks);
        }catch(Exception e){
            throw new RuntimeException("Error exportando tarea: "+e);
        }
    }

    public String buildSummary(Map<TaskStatus,Long> summary){
        return """
                ========== RESUMEN TASKFLOW ==========
                Pendientes      : %d
                En progreso     : %d
                Bloquedas       : %d
                Completadas     : %d
                ====================================== 
                """.formatted(
                        summary.getOrDefault(TaskStatus.PENDING,0L),
                        summary.getOrDefault(TaskStatus.IN_PROGRESS,0L),
                        summary.getOrDefault(TaskStatus.BLOCKED,0L),
                        summary.getOrDefault(TaskStatus.COMPLETED,0L)
        );
    }
}
