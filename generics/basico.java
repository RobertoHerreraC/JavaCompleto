package generics;

public class basico {
    static void main() {
        Caja<String> cajaTexto = new Caja<>("Hola Java");
        Caja<Integer> cataNumero = new Caja<>(15);

        System.out.println(cajaTexto.getContenido());
        System.out.println(cataNumero.getContenido());

        System.out.println(cajaTexto.tipo());
        System.out.println(cataNumero.tipo());
    }

    static class Caja<T>{
        private T contenido;
        public Caja(T contenido){
            this.contenido = contenido;
        }

        public T getContenido(){
            return contenido;
        }

        public String tipo(){
            return contenido.getClass().getSimpleName();
        }
    }

}
