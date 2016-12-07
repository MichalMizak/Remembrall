package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyLoanDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class LoanComboBoxModel extends DefaultComboBoxModel<Loan>{

/**
 *
 * @author Mikey
 */  
    private LoanDao loanDao = ObjectFactory.INSTANCE.getLoanDao();

    public LoanComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Loan> loans = loanDao.getLoans();
        
        for(Loan loan : loans) {
            addElement(loan);
        }        
    }
}
