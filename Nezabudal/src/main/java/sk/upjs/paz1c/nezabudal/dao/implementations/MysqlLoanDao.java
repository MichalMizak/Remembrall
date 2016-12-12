package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.LoanRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class MysqlLoanDao implements LoanDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    @Override
    public List<Loan> getLoans() {
        String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper());

        setItemById(loans);

        return loans;
    }

    @Override
    public Loan getByItem(Item item) {
        String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan"
                + "     WHERE item_id = ?;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper(), item.getId());

        if (loans.isEmpty()) {
            return null;
        }
        Loan loan = loans.get(0);
        loan.setItem(item);
        return loan;

    }

    @Override
    public Loan getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrEdit(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // other
    private void setItemById(List<Loan> loans) {
        for (Loan loan : loans) {
            setItemById(loan);
        }
    }

    private void setItemById(Loan loan) {
        loan.setItem(itemManager.getById(loan.getItem().getId()));
    }
}
