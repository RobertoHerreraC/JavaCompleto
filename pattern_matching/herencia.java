package pattern_matching;

public class herencia {
    static void main() {
        Animal animal = new Perro("Firulais");

        if(animal instanceof Perro perro){
            System.out.println("Es un perro llamado: "+perro.nombre);
        }else if(animal instanceof Gato gato){
            System.out.println("Es un gato con vidas: "+gato.vidas);
        }else{
            System.out.println("Animal desconocido");
        }
    }
}

class Animal{

}

class Perro extends Animal{
    String nombre;
    Perro(String nombre){
        this.nombre=nombre;
    }
}

class Gato extends Animal{
    int vidas;
    Gato(int vidas){
        this.vidas=vidas;
    }
}
