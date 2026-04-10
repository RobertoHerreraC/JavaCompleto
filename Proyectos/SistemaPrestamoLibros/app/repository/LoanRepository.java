package Proyectos.SistemaPrestamoLibros.app.repository;

import Proyectos.SistemaPrestamoLibros.app.model.Loan;

import java.util.*;

public class LoanRepository {
    private Map<Long, Loan> db = new HashMap<Long, Loan>();
    private Long idCounter=1L;

    public Loan save(Loan loan){
        if(loan.getId()==null) loan.setId(idCounter++);
        db.put(loan.getId(), loan);
        return loan;
    }

    public Optional<Loan> findById(Long id){
        return Optional.ofNullable(db.get(id));
    }

    public List<Loan> findAll(){
        return new ArrayList<>(db.values());
    }
}
