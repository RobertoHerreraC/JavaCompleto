package Proyectos.SistemaPrestamoLibros.app.model;

public class Loan {
    private Long id;
    private Book book;
    private String borrower;
    private LoanStatus status;

    public Loan(Long id, Book book, String borrower, LoanStatus status) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.status = status;
    }

    public void markAsReturned(){
        if(status==LoanStatus.RETURNED) throw new RuntimeException("El prestamo ya fue devuelto");

        status= LoanStatus.RETURNED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrower() {
        return borrower;
    }

    public LoanStatus getStatus() {
        return status;
    }
}
