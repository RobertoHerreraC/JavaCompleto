package Proyectos.SistemaPrestamoLibros.app.service;

import Proyectos.SistemaPrestamoLibros.app.dto.BookRequestDTO;
import Proyectos.SistemaPrestamoLibros.app.model.Book;
import Proyectos.SistemaPrestamoLibros.app.repository.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(BookRequestDTO bookRequestDTO) {
        if(bookRequestDTO.title==null|| bookRequestDTO.title.isEmpty()) throw new RuntimeException("El titulo no puede ser vacio");

        if(bookRequestDTO.stock<0) throw new RuntimeException("El stock no puede ser negativo");

        Book book = new Book(null,bookRequestDTO.title,bookRequestDTO.stock);
        return bookRepository.save(book);
    }

    public Book findById(Long id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book no encontrado"));
    }

    public List<Book> listAll(){
        return bookRepository.findAll();
    }

    public void decreaseStock(Book book){
        book.decreaseStock();
        bookRepository.save(book);
    }

    public void increasStock(Book book){
        book.increaseStock();
        bookRepository.save(book);
    }
}
