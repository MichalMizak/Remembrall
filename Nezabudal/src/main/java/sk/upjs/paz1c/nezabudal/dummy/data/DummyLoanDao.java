package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.entity.Loan;

/**
 *
 * @author Mikey
 */
public enum DummyLoanDao implements LoanDao{
    INSTANCE;

    @Override
    public List<Loan> getLoans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loan> getOwnedLoans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Loan> getNotOwnedLoans() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Loan getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
