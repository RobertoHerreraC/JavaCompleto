package _24_Fallback_observabilidad;

public class a_fallback_try_catch {
    static void main() {
        String respuesta = obtenerRespuestaSegura();
        System.out.println(respuesta);
    }

    public static String obtenerRespuestaSegura(){
        try{
            return consultarServicio();
        }catch (RuntimeException e){
            System.err.println("Error consultando servicio: "+e.getMessage());
            return "Servicio no disponible";
        }
    }

    public static String consultarServicio(){
        throw new RuntimeException("Timeout del servicio externo");
    }
}
