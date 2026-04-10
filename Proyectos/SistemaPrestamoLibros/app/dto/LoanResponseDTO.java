package Proyectos.SistemaPrestamoLibros.app.dto;

public class LoanResponseDTO {
    public Long loanId;
    public String bookTitle;
    public String borrower;
    public String status;

    public LoanResponseDTO(Long loanId, String bookTitle, String borrower, String status) {
        this.loanId = loanId;
        this.bookTitle = bookTitle;
        this.borrower = borrower;
        this.status = status;
    }

    @Override
    public String toString(){
        return "LoanResponseDTO{"+
                "loanId:"+ loanId+
                ", bookTitle:"+ bookTitle
                + ", borrower:"+ borrower
                + ", status:"+ status +"}";
    }
}
