package sealed;

public class record_sealed {
    static void main() {
        Resultado resultado1 = new Exito("Operacion realizada correctamente");
        Resultado resultado2 = new ErrorResultado("No se encontro el usuario");
        System.out.println(resultado1);
        System.out.println(resultado2);
    }

    sealed interface Resultado permits Exito, ErrorResultado{

    }

    record Exito(String mensaje) implements Resultado {

    }

    record ErrorResultado(String detalle) implements Resultado {

    }
}
