package Enum;

public class emun_comportamiento {
    static void main() {
        System.out.println(Operacion.SUMA.calcular(52,36));
        System.out.println(Operacion.RESTA.calcular(45,16));
        System.out.println(Operacion.DIVISION.calcular(52,0));
    }

    public enum Operacion{
        SUMA{
            @Override
            public double calcular(double a, double b) {
                return a+b;
            }
        },
        RESTA{
            @Override
            public double calcular(double a, double b) {
                return a-b;
            }
        },
        DIVISION{
            @Override
            public double calcular(double a, double b) {
                if(b==0) throw new ArithmeticException("No se puede dividir por cero.");
                return a/b;
            }
        };

        public abstract double calcular(double a, double b);
    }
}
