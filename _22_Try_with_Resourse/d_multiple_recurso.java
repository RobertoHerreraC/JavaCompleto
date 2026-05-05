package _22_Try_with_Resourse;

import java.io.*;

public class d_multiple_recurso {
    static void main() {
        try(
                BufferedReader reader = new BufferedReader(new FileReader("snacks.txt"));
                BufferedWriter writer = new BufferedWriter(new FileWriter("copia.txt"))
                ){
            String linea;
            while((linea = reader.readLine())!=null){
                writer.write(linea);
                writer.newLine();
            }

            System.out.println("Archivo copiado correctamente");
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
