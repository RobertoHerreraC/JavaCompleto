package ejercicios;


import java.time.LocalDate;
import java.time.Period;

class Persona{
    private LocalDate fechaNacimiento;

    public Persona(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public void validadMayorEdad() throws Exception{
        if(calcularEdad()<18) throw new Exception("Menor de edad");
    }
}

public class ejercicio005 {

    static void main() {
        try{
            Persona p = new Persona(LocalDate.of(2000,1,1));
            p.validadMayorEdad();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
