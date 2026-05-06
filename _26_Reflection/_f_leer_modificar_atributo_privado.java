package _26_Reflection;

import java.lang.reflect.Field;

public class _f_leer_modificar_atributo_privado {
    static void main () throws Exception {
        Cuenta cuenta = new Cuenta();
        Field campo = Cuenta.class.getDeclaredField("saldo");
        campo.setAccessible(true);
        double saldoActual = (double) campo.get(cuenta);
        System.out.println("saldo actual: " + saldoActual);

        campo.set(cuenta,500.0);
        System.out.println("saldo actual: " + cuenta.getSaldo());
    }
}
class Cuenta{
    private double saldo = 100.0;
    public double getSaldo(){
        return saldo;
    }
}
