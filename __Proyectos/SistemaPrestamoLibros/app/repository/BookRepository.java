package __Proyectos.SistemaPrestamoLibros.app.repository;

import __Proyectos.SistemaPrestamoLibros.app.model.Book;

import java.util.*;

public class BookRepository {
    private Map<Long, Book> db = new HashMap<>();
    private Long idCounter=1L;

    public Book save(Book book) {
        if(book.getId()==null) book.setId(idCounter++);
        db.put(book.getId(), book);
        return book;
    }
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public List<Book> findAll(){
        return new ArrayList<>(db.values());
    }
}
