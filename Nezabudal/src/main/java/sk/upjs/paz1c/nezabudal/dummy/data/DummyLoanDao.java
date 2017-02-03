package sk.upjs.paz1c.nezabudal.dummy.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Person;

/**
 *
 * @author Mikey
 */
public class DummyLoanDao implements LoanDao {
    Loan loan;

    public DummyLoanDao() { 
        
        Category category = ObjectFactory.INSTANCE.getCategoryManager().getById(2L);
        List<Attribute> attributes = ObjectFactory.INSTANCE.getAttributeManager().getByCategory(category);
        Item item = new Item("Dummy item name", "Dummy item description",  true, category, attributes);
        
        loan = new Loan(item, "Dummy loan spec", true, new Person(), 
                LocalDateTime.now(), LocalDateTime.MIN);
    }

    @Override
    public List<Loan> getLoans() {
        List<Loan> list = new ArrayList<>();
        list.add(loan);
        return list;
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

    @Override
    public void saveOrEdit(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
