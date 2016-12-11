package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyLoanDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;

/**
 *
 * @author Mikey
 */
public class LoanComboBoxModel extends DefaultComboBoxModel<Loan>{

/**
 *
 * @author Mikey
 */  
    private LoanManager loanManager = ObjectFactory.INSTANCE.getLoanManager();

    public LoanComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Loan> loans = loanManager.getLoans();
        
        for(Loan loan : loans) {
            addElement(loan);
        }        
    }
}
