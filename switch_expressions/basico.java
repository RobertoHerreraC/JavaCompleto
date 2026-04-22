package switch_expressions;

public class basico {
    static void main() {
        int dia = 10;

        String nombreDia = switch(dia){
            case 1-> "Lunes";
            case 2-> "Martes";
            case 3-> "Miercoles";
            case 4-> "Jueves";
            case 5-> "Viernes";
            case 6-> "Sabado";
            case 7-> "Domingo";
            default->"Dia invalido";
        };

        System.out.println(nombreDia);

    }
}
