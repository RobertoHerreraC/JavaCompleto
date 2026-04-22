package Enum;

public class ejercicio_5 {
    static void main() {
        TipoEnvio envio = TipoEnvio.EXPRESS;
        System.out.println(envio.getDescripcion());
        System.out.println(envio.calcularCosto(3));
    }

    public enum TipoEnvio{
        NORMAL("Envío estándar", 10){
            @Override
            public double calcularCosto(double peso){
                return costoBase + (peso *2);
            }
        },
        EXPRESS("Envío rápido", 20){
            @Override
            public double calcularCosto(double peso){
                return costoBase + (peso * 5);
            }
        };
        protected final double costoBase;
        private final String descripcion;

        TipoEnvio(String descripcion, double costoBase) {
            this.descripcion = descripcion;
            this.costoBase = costoBase;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public abstract double calcularCosto(double peso);

    }


}
