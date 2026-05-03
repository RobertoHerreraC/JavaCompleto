package _10_switch_expressions;

public class con_yield {
    static void main() {
        int nota = 16;
        String resultado = switch(nota/4){
          case 5,4 ->{
              System.out.println("Rendimiento alto");
              yield "Excelente";
          }
          case 3 -> {
              System.out.println("Rendimiento aceptable");
              yield "Aprobado";
          }
          default ->{
              System.out.println("Rendimiento bajo");
              yield "Desaprobado";
          }
        };

        System.out.println(resultado);
    }
}
