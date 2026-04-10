package Proyectos.SistemaPrestamoLibros.app.service;

import Proyectos.SistemaPrestamoLibros.app.dto.LoanRequestDTO;
import Proyectos.SistemaPrestamoLibros.app.dto.LoanResponseDTO;
import Proyectos.SistemaPrestamoLibros.app.model.Book;
import Proyectos.SistemaPrestamoLibros.app.model.Loan;
import Proyectos.SistemaPrestamoLibros.app.model.LoanStatus;
import Proyectos.SistemaPrestamoLibros.app.repository.BookRepository;
import Proyectos.SistemaPrestamoLibros.app.repository.LoanRepository;

import java.util.List;
import java.util.stream.Collectors;

public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;

    public LoanService(LoanRepository loanRepository,BookService bookService){
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public LoanResponseDTO borrowBook(LoanRequestDTO loanRequestDTO){
        Book book = bookService.findById(loanRequestDTO.bookId);
        bookService.decreaseStock(book);
        Loan loan = new Loan(null,book, loanRequestDTO.borrower, LoanStatus.ACTIVE);
        Loan saved = loanRepository.save(loan);

        return mapToDTO(saved);
    }

    public LoanResponseDTO returnBook(Long loanId){
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(()-> new RuntimeException("Prestamo no encontrado"));
        loan.markAsReturned();
        bookService.increasStock(loan.getBook());
        loanRepository.save(loan);
        return mapToDTO(loan);
    }

    public List<LoanResponseDTO> listActiveLoans(){
        return loanRepository.findAll()
                .stream()
                .filter(l -> l.getStatus()==LoanStatus.ACTIVE)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private LoanResponseDTO mapToDTO(Loan loan){
        return new LoanResponseDTO(
                loan.getId(),
                loan.getBook().getTitle(),
                loan.getBorrower(),
                loan.getStatus().name()
        );
    }

}
