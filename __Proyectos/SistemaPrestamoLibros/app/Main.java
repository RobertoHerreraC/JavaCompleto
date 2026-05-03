package __Proyectos.SistemaPrestamoLibros.app;

import __Proyectos.SistemaPrestamoLibros.app.controller.LibraryController;
import __Proyectos.SistemaPrestamoLibros.app.repository.BookRepository;
import __Proyectos.SistemaPrestamoLibros.app.repository.LoanRepository;
import __Proyectos.SistemaPrestamoLibros.app.service.BookService;
import __Proyectos.SistemaPrestamoLibros.app.service.LoanService;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        LoanRepository loanRepository = new LoanRepository();

        BookService bookService = new BookService(bookRepository);
        LoanService loanService = new LoanService(loanRepository,bookService);

        LibraryController libraryController = new LibraryController(bookService,loanService);
        libraryController.createBook("Clean code",2);
        libraryController.createBook("Effective java",3);

        libraryController.listBooks();

        libraryController.borrowBook(1L,"Roberto");
        libraryController.borrowBook(2L,"Roberto");
        libraryController.borrowBook(2L,"Kateryn");

        libraryController.listBooks();
        libraryController.listActiveLoans();

        libraryController.returnBook(1L);
        libraryController.listBooks();
        libraryController.listActiveLoans();

    }
}
