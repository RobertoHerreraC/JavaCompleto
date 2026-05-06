package _26_Reflection;

public class _a_metada_class {
    static void main() {
        Class<?> clazz = Usuario.class;
        System.out.println("Nombre completo: "+clazz.getName());
        System.out.println("Nombre simple:"+clazz.getSimpleName());
        System.out.println("Paquete:"+clazz.getPackageName());
        System.out.println("Es interface?:"+clazz.isInterface());
    }
}
class Usuario{

}
