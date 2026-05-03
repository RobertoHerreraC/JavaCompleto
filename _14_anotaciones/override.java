package _14_anotaciones;

public class override {
    static void main() {
        Animal animal = new Perro();
        animal.hacerSonido();
    }
}

class Animal{
    public void hacerSonido(){
        System.out.println("Sonido generido");
    }
}

class Perro extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }
}
