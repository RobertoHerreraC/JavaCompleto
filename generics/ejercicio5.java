package generics;

public class ejercicio5 {
    static void main() {
        Respuesta<String> r1 = new Respuesta<>("Usuario creado", "Exito");
        Respuesta<Integer> r2 = new Respuesta<>("Codigo HTTP",200);

        System.out.println(r1.getMensaje()+" : "+r1.getData());
        System.out.println(r2.getMensaje()+" : "+r2.getData());
    }
}

class Respuesta<T>{
    private String mensaje;
    private T data;

    public Respuesta(String mensaje, T data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getData() {
        return data;
    }
}
