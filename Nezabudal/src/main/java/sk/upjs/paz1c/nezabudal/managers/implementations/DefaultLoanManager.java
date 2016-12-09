package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;

/**
 *
 * @author Mikey
 */
public class DefaultLoanManager implements LoanManager {

    LoanDao loanDao = ObjectFactory.INSTANCE.getLoanDao();

    @Override
    public List<Loan> getLoans() {
        return loanDao.getLoans();
    }

    @Override
    public Loan getByItem(Item item) {
        return loanDao.getByItem(item);
    }

    @Override
    public Loan getById(Long id) {
        return loanDao.getById(id);
    }

    @Override
    public void delete(Loan loan) {
        loanDao.delete(loan);
    }

}
