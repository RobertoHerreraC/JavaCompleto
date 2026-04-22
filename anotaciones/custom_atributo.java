package anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class custom_atributo {
    static void main() {
       ServicioPago servicioPago = new ServicioPago();
       System.out.println(servicioPago);
    }
}

@Target(ElementType.TYPE)
@interface Info{
    String autor();
    int version();
}

@Info(autor="Roberto",version=1)
class ServicioPago{

}