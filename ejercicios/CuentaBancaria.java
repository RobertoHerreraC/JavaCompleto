package ejercicios;
//Ejercicio 002
public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial){
        this.saldo = saldoInicial;
    }

    public void depositar(double monto){
        saldo += monto;
    }

    private void retirar(double monto){
        if(monto <= saldo){
            saldo += monto;
        }else{
            System.out.println("Saldo insuficientes");
        }
    }

    public double getSaldo(){
        return saldo;
    }
}
