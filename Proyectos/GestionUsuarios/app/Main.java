package Proyectos.GestionUsuarios.app;

import Proyectos.GestionUsuarios.app.controller.UserController;

public class Main {
    static void main() {
        UserController userController = new UserController();
        userController.register("rcherrera", "12364dfs");
        userController.register("klevano", "741258");
        userController.register("herrelev", "def%$3");

        userController.listUser();

        userController.login("rcherrera", "12364dfs");
        userController.login("rcherrera", "12364dddd");
    }
}
