package __Proyectos.MaquinaSnacksArchivos.src.servicio;

import __Proyectos.MaquinaSnacksArchivos.src.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerivicioSnacksArchivos implements IServicioSnacks{
    private final String NOMBRE_ARCHIVO = "snacks.txt";
    private List<Snack> snacks = new ArrayList<>();

    public SerivicioSnacksArchivos(){
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try{
            existe = archivo.exists();
            if(existe){
                this.snacks = obtenerSnacks();
            }else{
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch(Exception ex){
            System.out.println("Error al crear el archivo: "+ ex.getMessage());
        }
        if(!existe) cargarSnacksIniciales();
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Papa",70));
        this.agregarSnack(new Snack("Hamburguesa",140));
        this.agregarSnack(new Snack("Chocolate",1.50));
    }

    private List<Snack> obtenerSnacks(){
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea : lineas){
                String[] lineasSnack = linea.split(",");
                var idSnack = lineasSnack[0];
                var nombre  = lineasSnack[1];
                var precio = Double.parseDouble(lineasSnack[2]);
                var snack = new Snack(nombre,precio);
                snacks.add(snack);
            }
        }catch(Exception ex){
            System.out.println("Error al leer el archivo: "+ ex.getMessage());
            ex.printStackTrace();
        }
        return snacks;
    }
    private void agregarSnackArchivo(Snack snack){
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        }catch(Exception ex){
            System.out.println("Error al agregar el snack: "+ ex.getMessage());
        }
    }

    @Override
    public void agregarSnack(Snack snack) {
        this.snacks.add(snack);
        this.agregarSnackArchivo(snack);
    }

    @Override
    public void mostrarSnack() {
        System.out.println("--- Snacks en el inventario ---");
        var inventario = "";
        for(var snack:this.snacks){
            inventario += snack.toString()+"\n";
        }
        System.out.println(inventario);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
