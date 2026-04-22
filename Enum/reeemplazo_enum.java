package Enum;

public class reeemplazo_enum {
    static void main() {
        CanalNotificacion canal = CanalNotificacion.EMAIL;
        canal.enviar("Hola Roberto");
    }

    public enum CanalNotificacion{
        EMAIL{
            @Override
            public void enviar(String mensaje){
                System.out.println("Enviando email: "+mensaje);
            }
        },
        SMS{
            @Override
            public void enviar(String mensaje){
                System.out.println("Enviando sms: "+mensaje);
            }
        },
        PUSH{
           @Override
           public void enviar(String mensaje){
               System.out.println("Enviando push: "+mensaje);
           }
        };

        public abstract void enviar(String mensaje);
    }

}
