package __Proyectos._08_taskflow.model;

import java.time.LocalDateTime;

public record Comment(String author, String message, LocalDateTime createdAt) {
}
