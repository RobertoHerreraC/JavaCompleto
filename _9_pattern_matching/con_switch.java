package _9_pattern_matching;

public class con_switch {
    static void main() {
        Object obj = 25;

        String resultado = describir(obj);
        System.out.println(resultado);
    }

    public static String describir(Object obj){
        return switch(obj){
            case String s -> "Texto: "+s;
            case Integer i-> "Entero: "+i;
            case Double d -> "Decimal: "+d;
            default -> "Tipo no soportado";
        };
    }
}
