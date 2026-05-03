package _1_POO.library;

import java.time.LocalDate;

public class Loan {
    private final Book book;
    private final Member member;
    private final LocalDate loanDate;


    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
    }

    public Book getBook(){
        return book;
    }

    public Member getMember(){
        return member;
    }
}
