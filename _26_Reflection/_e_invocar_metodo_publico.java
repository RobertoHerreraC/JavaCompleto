package _26_Reflection;

import java.lang.reflect.Method;

public class _e_invocar_metodo_publico {
    static void main() throws Exception {
        SaludoService service = new SaludoService();
        Method metodo = SaludoService.class.getDeclaredMethod("saludar",String.class);
        Object resultado = metodo.invoke(service,"Roberto");
        System.out.println(resultado);
    }
}

class SaludoService{
    public String saludar(String nombre){
        return "Hola "+nombre;
    }
}
