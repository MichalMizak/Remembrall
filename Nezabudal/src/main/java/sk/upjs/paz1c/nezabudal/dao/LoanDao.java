package sk.upjs.paz1c.nezabudal.dao;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Loan;

/**
 *
 * @author Mikey
 */
public interface LoanDao {
    
    List<Loan> getLoans();

    // the loans where I (the app user) borrowed an item
    List<Loan> getOwnedLoans();
    
    // the loans where I (the app user) lent an item
    List<Loan> getNotOwnedLoans();
    
    Loan getById(Long id);  
    
    void delete(Loan loan);
}
