package _22_Try_with_Resourse;

public class a_recurso_custom_AutoCloseable {
    static void main() {
        try(ConexionFake conexion = new ConexionFake()){
            conexion.abrir();
            conexion.consultar();
        }
    }
}

class ConexionFake implements AutoCloseable{
    public void abrir(){
        System.out.println("Conexion abierta");
    }

    public void consultar(){
        System.out.println("Consultando datos...");
    }

    @Override
    public void close() {
        System.out.println("Conexion cerrada automaticamente");
    }
}
