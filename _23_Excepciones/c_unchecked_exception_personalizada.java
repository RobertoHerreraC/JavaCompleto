package _23_Excepciones;

public class c_unchecked_exception_personalizada {
    static void main() {
        validarEdad(15);
    }

    public static void validarEdad(int edad){
        if(edad<18){
            throw new EdadInvalidaException("La edad minima es 18");
        }
        System.out.println("Edad valida");
    }

}

class EdadInvalidaException extends RuntimeException{
    public EdadInvalidaException(String mensaje){
        super(mensaje);
    }
}
