package _9_pattern_matching;

public class condicional {
    static void main() {
        Object obj = 5;
        if(obj instanceof Integer numero && numero>10){
            System.out.println("Doble:"+(numero*2));
        }else{
            System.out.println("No cumple las condiciones");
        }
    }
}
