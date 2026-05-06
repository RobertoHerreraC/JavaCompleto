package _26_Reflection;

import java.lang.reflect.Constructor;

public class _d_crear_objeto {
    static void main() throws Exception {
        Class<Usuario1> clazz = Usuario1.class;
        Constructor<Usuario1> constructor = clazz.getDeclaredConstructor();
        Usuario1 usuario = constructor.newInstance();
        System.out.println("objeto creado:" +usuario);
    }
}

class Usuario1{
    public Usuario1(){
        System.out.println("Iniciando usuario");
    }
}