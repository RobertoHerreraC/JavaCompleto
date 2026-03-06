package POO.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final List<Loan> loans = new ArrayList<>();

    public void borrowBook(Book book, Member member){
        if(!book.isAvailable()){
            throw new IllegalArgumentException("Book no available");
        }
        long currentLoans = loans.stream()
                .filter(l -> l.getMember().equals(member))
                .count();

        if(currentLoans >= member.maxBooksAllowed()){
            throw new IllegalArgumentException("Loan limit reached");
        }
        book.borrow();
        loans.add(new Loan(book, member));
    }
}
