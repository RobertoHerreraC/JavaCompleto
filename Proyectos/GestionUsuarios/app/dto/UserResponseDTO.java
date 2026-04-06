package Proyectos.GestionUsuarios.app.dto;

public class UserResponseDTO {
    public Long id;
    public String username;
    public boolean active;

    public UserResponseDTO(Long id, String username,boolean active) {
        this.id = id;
        this.username = username;
        this.active = active;
    }

}
