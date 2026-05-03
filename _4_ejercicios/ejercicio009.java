package _4_ejercicios;

class EdadInvalidaException extends Exception{
    public EdadInvalidaException(String msg){
        super(msg);
    }
}

class Persona2{
    int edad;
    public Persona2(int edad) throws EdadInvalidaException{
        if(edad<18)throw new EdadInvalidaException("Menor de edad");

        this.edad=edad;
    }
}

public class ejercicio009 {
    public static void main(String[] args) {
        try{
            Persona2 persona = new Persona2(20);
        }catch(EdadInvalidaException e){
            System.out.println(e.getMessage());
        }


    }

}
