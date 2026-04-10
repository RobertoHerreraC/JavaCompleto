package Proyectos.MaquinaSnacks.src;

import java.util.ArrayList;
import java.util.List;

public class Snacks {
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("papas",70));
        snacks.add(new Snack("refrescos",50));
        snacks.add(new Snack("hamburgesa",15));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnack(){
        var inventarioSnack ="";
        for(var snack: snacks){
            inventarioSnack += snack.toString()+ "\n";
        }
        System.out.println("--- Snack en el inventario ---");
        System.out.println(inventarioSnack);
    }

    public static List<Snack> getSnacks(){
        return List.copyOf(snacks);
    }


}
