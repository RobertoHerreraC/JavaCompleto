package __Proyectos.MaquinaSnacks.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
    static void main() {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        var salir = false;
        var consola = new Scanner(System.in);

        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de snack ***");
        Snacks.mostrarSnack();

        while(!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpciones(opcion, consola,productos);
            }catch(Exception e){
                System.out.println("Ocurrio un error: "+ e.getMessage());
            }finally{
                System.out.println();
            }
        }
    }

    private static int mostrarMenu(Scanner sc){
        System.out.print("""
                Menu:
                1. Comprar Snack
                2. Mostrar ticket
                3. Agregar nuevo snack
                4. Salir
                Elige una opcion: \s
                """);

        return Integer.parseInt(sc.nextLine());
    }

    private static boolean ejecutarOpciones(Integer opcion, Scanner sc, List<Snack> productos){
        var salir = false;
        switch (opcion){
            case 1 -> comprarSnack(sc,productos);
            case 2 -> mostrarTicket(productos);
            case 3 -> agregarSnack(sc);
            case 4 -> salir = true;
            default -> System.out.println("Opcion invalida");
        }
        return salir;
    }

    private static void comprarSnack(Scanner sc, List<Snack> productos){
        System.out.print("Que snack quiere comprar(id):");
        var idSnack = Integer.parseInt(sc.nextLine());
        var snackEncontrado = false;
        for(var snack : Snacks.getSnacks()){
            if(snack.getIdSnack() == idSnack){
                productos.add(snack);
                System.out.println("OK, snack agregado!");
                snackEncontrado = true;
                break;
            }
        }

        if(!snackEncontrado){
            System.out.println("Id snack no encontrado: "+idSnack);
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        var ticket = "*** Ticket de venta ***";
        var total = 0.0;
        for(var snack : productos){
            ticket += "\n\t" + snack.getNombre() + " - s/."+snack.getPrecio();
            total +=  snack.getPrecio();
        }

        ticket +="\n\tTotal -> s/."+ total;
        System.out.println(ticket);
    }

    private static void agregarSnack(Scanner sc){
        System.out.print("Nombre del snack: ");
        var nombre = sc.nextLine();
        System.out.print("Precio del snack: ");
        var precio = Double.parseDouble(sc.nextLine());
        Snacks.agregarSnack(new Snack(nombre,precio));
        System.out.println("Snack agregado!");
        Snacks.mostrarSnack();
    }
}
