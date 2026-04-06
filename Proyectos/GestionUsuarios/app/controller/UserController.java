package Proyectos.GestionUsuarios.app.controller;

import Proyectos.GestionUsuarios.app.dto.LoginRequestDTO;
import Proyectos.GestionUsuarios.app.dto.UserRequestDTO;
import Proyectos.GestionUsuarios.app.service.UserService;

public class UserController {
    private UserService service = new UserService();

    public void register(String username, String password){
        try{
            UserRequestDTO dto = new UserRequestDTO();
            dto.username = username;
            dto.password = password;
            System.out.println("Registrando usuario");
            System.out.println(service.register(dto));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void login(String username, String password){
        try{
            LoginRequestDTO dto = new LoginRequestDTO();
            dto.username = username;
            dto.password = password;
            System.out.println("Login...");
            System.out.println(service.login(dto));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }

    public void listUser(){
        System.out.println("Listando usuarios");
        service.listUsers().forEach(System.out::println);
    }
}
