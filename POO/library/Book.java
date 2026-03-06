package POO.library;

public class Book {
    private final String title;
    private final String author;
    private boolean available;

    public Book(String title, String author) {
        if(title == null || title.isBlank()){
            throw new IllegalArgumentException("Invalid title");
        }

        this.title = title;
        this.author = author;
        this.available = true;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void borrow(){
        if(!this.available){
            throw new IllegalStateException("Book not available");
        }
        this.available = false;
    }

    public void returnBook(){
        this.available = true;
    }

    public String getTitle(){
        return this.title;
    }
}
