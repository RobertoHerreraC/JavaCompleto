package Proyectos.taskflow.model;

import java.time.LocalDateTime;

public record Comment(String author, String message, LocalDateTime createdAt) {
}
