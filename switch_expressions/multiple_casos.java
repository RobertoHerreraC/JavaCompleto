package switch_expressions;

public class multiple_casos {
    static void main() {
        int dia = 6;

        String tipoDia = switch(dia){
            case 1,2,3,4,5 -> "Dia laborable";
            case 6,7 -> "Fin de semana";
            default ->"Dia invalido";
        };

        System.out.println(tipoDia);
    }
}
