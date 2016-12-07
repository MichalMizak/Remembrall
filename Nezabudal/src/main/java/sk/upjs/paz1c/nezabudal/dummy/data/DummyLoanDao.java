package sk.upjs.paz1c.nezabudal.dummy.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public class DummyLoanDao implements LoanDao {
    Loan loan;

    public DummyLoanDao() {
        loan = new Loan(ObjectFactory.INSTANCE.getItemDao().getById(0L), 
                "Dummy loan spec", true, "Mike", LocalDateTime.now(), LocalDateTime.MIN);
    }

    @Override
    public List<Loan> getLoans() {
        List<Loan> list = new ArrayList<>();
        list.add(loan);
        return list;
    }

    @Override
    public List<Loan> getOwnedLoans() {
        return null;
    }

    @Override
    public List<Loan> getNotOwnedLoans() {
        return getLoans();
    }

    @Override
    public Loan getById(Long id) {
        return loan;
    }

    @Override
    public void delete(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loan getByItem(Item item) {
        return getById(0L);
    }
}
