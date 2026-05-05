package _24_Fallback_observabilidad;

public class g_respuesta_parcial_fallback {
    static void main() {
        PerfilService service = new PerfilService();
        PerfilUsuario perfil = service.obtenerPerfil(1);
        System.out.println(perfil);
    }
}

record PerfilUsuario(String nombre, String deudaEstado){}

class PerfilService{
    public PerfilUsuario obtenerPerfil(int usuarioId){
        String nombre = consultarNombre(usuarioId);
        String deudaEstado = consultarDeudaFallback(usuarioId);

        return new PerfilUsuario(nombre, deudaEstado);
    }

    private String consultarNombre(int usuarioId){
        return "Roberto";
    }

    private String consultarDeudaFallback(int usuarioId){
        try{
            double deuda = consultarDeuda(usuarioId);
            return "Deuda: %.2f".formatted(deuda);
        }catch (RuntimeException e){
            System.err.println("No se pudo consultar deuda: "+e.getMessage());
            return "DEUDA_NO_DISPONIBLE";
        }
    }

    private double consultarDeuda(int usuarioId){
        throw new RuntimeException("Servicio de deuda caido");
    }
}