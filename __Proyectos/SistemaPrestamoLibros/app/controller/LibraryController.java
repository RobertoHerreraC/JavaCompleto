package __Proyectos.SistemaPrestamoLibros.app.controller;

import __Proyectos.SistemaPrestamoLibros.app.dto.BookRequestDTO;
import __Proyectos.SistemaPrestamoLibros.app.dto.LoanRequestDTO;
import __Proyectos.SistemaPrestamoLibros.app.dto.LoanResponseDTO;
import __Proyectos.SistemaPrestamoLibros.app.model.Book;
import __Proyectos.SistemaPrestamoLibros.app.service.BookService;
import __Proyectos.SistemaPrestamoLibros.app.service.LoanService;

public class LibraryController {
    private final BookService bookService;
    private final LoanService loanService;

    public LibraryController(BookService bookService, LoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }

    public void createBook(String title, int stock){
        BookRequestDTO dto = new BookRequestDTO();
        dto.title=title;
        dto.stock=stock;

        Book book = bookService.create(dto);
        System.out.println("Libro creado: "+book.getTitle() +" - "+ book.getId());
    }

    public void listBooks(){
        System.out.println("Listado de libro:");
        bookService.listAll().forEach(book -> System.out.println(book.getTitle()));
    }

    public void borrowBook(Long bookId, String borrower){
        LoanRequestDTO dto =  new LoanRequestDTO();
        dto.bookId=bookId;
        dto.borrower=borrower;

        LoanResponseDTO response = loanService.borrowBook(dto);
        System.out.println("Prestamo Creado: "+response);
    }

    public void returnBook(Long loanId){
        LoanResponseDTO response = loanService.returnBook(loanId);
        System.out.println("Prestamo devuelto: "+response);
    }

    public void listActiveLoans(){
        System.out.println("Listado de active loans:");
        loanService.listActiveLoans().forEach(System.out::println);
    }
}
