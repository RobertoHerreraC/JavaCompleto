package serializacion;

import java.io.*;

public class con_transient {
    static void main() {
        Cuenta cuenta = new Cuenta("Roberto", 1500.0,"12354689");
        try{
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cuenta.dat"));
//            out.writeObject(cuenta);
//            out.close();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("cuenta.dat"));
            Cuenta recuperado = (Cuenta) in.readObject();
            in.close();
            System.out.println(recuperado);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Cuenta implements Serializable{
    private static final long serialVersionUID = 1L;
    private String titular;
    private double saldo;
    private transient String password;

    public Cuenta(String titular, double saldo, String password) {
        this.titular = titular;
        this.saldo = saldo;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", password='" + password + '\'' +
                '}';
    }
}
