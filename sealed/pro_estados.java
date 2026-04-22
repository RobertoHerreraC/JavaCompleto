package sealed;

public class pro_estados {
    static void main() {
        EstadoPedido estado1 = new Pendiente();
        EstadoPedido estado2 = new Pagado();
        EstadoPedido estado3 = new Cancelado();

        System.out.println(estado1.descripcion());
        System.out.println(estado2.descripcion());
        System.out.println(estado3.descripcion());

    }

    static abstract sealed class EstadoPedido permits Pendiente, Pagado, Cancelado{
        public abstract String descripcion();
    }

    static final class Pendiente extends EstadoPedido{
        @Override
        public String descripcion() {
            return "El pedido esta pendiente.";
        }
    }

    static final class Pagado extends EstadoPedido{
        @Override
        public String descripcion() {
            return "El pagado ya esta pagado.";
        }
    }

    static final class Cancelado extends EstadoPedido{
        @Override
        public String descripcion() {
            return "El pagado fue cancelado.";
        }
    }

}
