package Proyectos.MaquinaSnacksArchivos.src.servicio;

import Proyectos.MaquinaSnacksArchivos.src.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksLista implements IServicioSnacks{
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("papas",70));
        snacks.add(new Snack("refrescos",50));
        snacks.add(new Snack("hamburgesa",15));
    }

    public void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public void mostrarSnack(){
        var inventarioSnack ="";
        for(var snack: snacks){
            inventarioSnack += snack.toString()+ "\n";
        }
        System.out.println("--- Snack en el inventario ---");
        System.out.println(inventarioSnack);
    }

    public List<Snack> getSnacks(){
        return List.copyOf(snacks);
    }


}
