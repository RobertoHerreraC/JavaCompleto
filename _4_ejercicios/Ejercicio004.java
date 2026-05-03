package _4_ejercicios;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio004 {
    static void main() {
        String texto = "hola mundo hola java mundo";
        String[] palabras = texto.split(" ");

        Map<String, Integer> conteo = new HashMap<>();

        for(String palabra: palabras){
            conteo.put(palabra, conteo.getOrDefault(palabra,0)+1);
        }
        System.out.println(conteo);
    }
}
