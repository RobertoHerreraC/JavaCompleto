package _9_pattern_matching;

public class basico {
    static void main() {
        Object obj = "hola java";
        if(obj instanceof String str){
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("No es uns string");
        }
    }
}
