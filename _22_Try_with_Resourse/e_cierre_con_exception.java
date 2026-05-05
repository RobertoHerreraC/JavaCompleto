package _22_Try_with_Resourse;

public class e_cierre_con_exception {
    static void main() {
        try(Recurso recurso1 = new Recurso()){
            recurso1.usar();
            throw new RuntimeException("Error durante el uso del recurso");
        }catch (RuntimeException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}

class Recurso implements AutoCloseable {
    public void usar(){
        System.out.println("Usando recurso");
    }

    @Override
    public void close() {
        System.out.println("Cerrando recurso automaticamente");
    }
}
