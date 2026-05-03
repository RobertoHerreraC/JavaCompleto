package __Proyectos.SistemaPrestamoLibros.app.model;

public class Book {

    private Long id;
    private String title;
    private int stock;

    public Book(Long id, String title, int stock){
        this.id = id;
        this.title = title;
        this.stock = stock;
    }

    public void decreaseStock(){
        if(stock <= 0) throw new RuntimeException("No hay stock disponibles");

        stock--;
    }

    public void increaseStock(){
        stock++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getStock() {
        return stock;
    }
}
