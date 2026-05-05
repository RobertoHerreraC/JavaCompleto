package _23_Excepciones;

public class e_validacion_negocio {
    static void main() {
        CuentaService service = new CuentaService();
        try {
            service.retirar(150);
        }catch (SaldoInsuficienteException e){
            System.out.println("Error de negocio: "+e.getMessage());
        }
    }


}

class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

class CuentaService{
    private double saldo = 100;
    public void retirar(double monto){
        if(monto<=0){
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }
        if(monto>saldo){
            throw new SaldoInsuficienteException("Saldo insuficiente, saldo actual: "+saldo);
        }
        saldo -= monto;
        System.out.println("Retiro exitoso, nuevo saldo: "+saldo);
    }
}