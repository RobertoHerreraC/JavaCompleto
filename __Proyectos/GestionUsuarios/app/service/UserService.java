package __Proyectos.GestionUsuarios.app.service;

import __Proyectos.GestionUsuarios.app.dto.LoginRequestDTO;
import __Proyectos.GestionUsuarios.app.dto.UserRequestDTO;
import __Proyectos.GestionUsuarios.app.dto.UserResponseDTO;
import __Proyectos.GestionUsuarios.app.model.User;
import __Proyectos.GestionUsuarios.app.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public UserResponseDTO register(UserRequestDTO dto){
        userRepository.findByUsername(dto.username)
                .ifPresent(u->{
                   throw new RuntimeException("Username ya existente");
                });

        User user = new User(null, dto.username, dto.password, true);
        userRepository.save(user);
        System.out.println("Usuario "+ user.getId() + "registrado");
        return mapToDTO(user);
    }

    public UserResponseDTO login(LoginRequestDTO dto){
        User user = userRepository.findByUsername(dto.username)
                .orElseThrow(()->new RuntimeException("Username no existente"));

        if(!user.getPassword().equals(dto.password)) throw new RuntimeException("Credenciales incorrectas");
        return mapToDTO(user);
    }

    public List<UserResponseDTO> listUsers(){
        return userRepository.findAll().stream()
                .map(this::mapToDTO).
                collect(Collectors.toList());
    }

    private UserResponseDTO mapToDTO(User user){
        return new UserResponseDTO(user.getId(), user.getUsername(),user.isActive());
    }

}
