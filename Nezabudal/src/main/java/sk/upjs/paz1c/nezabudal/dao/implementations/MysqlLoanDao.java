package sk.upjs.paz1c.nezabudal.dao.implementations;

import sk.upjs.paz1c.nezabudal.managers.PersonManager;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.LoanRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class MysqlLoanDao implements LoanDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    PersonManager personManager = ObjectFactory.INSTANCE.getPersonManager();

    @Override
    public List<Loan> getLoans() {
        String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person_id as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper());

        setItemById(loans);
        setPersonById(loans);

        return loans;
    }

    @Override
    public Loan getByItem(Item item) {
        String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person_id as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan WHERE item_id = ?;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper(), item.getId());

        if (loans.isEmpty()) {
            return null;
        }
        Loan loan = loans.get(0);
        loan.setItem(item);
        setPersonById(loan);

        return loan;

    }

    @Override
    public Loan getById(Long loanId) {
        String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person_id as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan"
                + "     WHERE id = ?;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper(), loanId);
        if (loans.isEmpty()) {
            return null;
        }
        Loan loan = loans.get(0);

        setItemById(loan);
        setPersonById(loan);
        return loan;
    }

    @Override
    public void delete(Loan loan) {
        if (loan == null) {
            return;
        }
        String sql = "DELETE from loan where id = ?";
        Item item = loan.getItem();
        item.setIsBorrowed(false);
        itemManager.saveOrEdit(item);
        personManager.saveOrEdit(loan.getPerson());
        jdbcTemplate.update(sql, loan.getId());
    }

    @Override
    public void saveOrEdit(Loan newLoan) {
        Item newItem = newLoan.getItem();

        if (newLoan.getId() == null) {

            String saveSql = "INSERT into loan values (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(saveSql, null, newItem.getId(), newLoan.getSpecification(),
                    newLoan.isLentToMe(), newLoan.getPerson().getId(), newLoan.getStartDate(), newLoan.getReturnDate());

            newItem.setIsBorrowed(true);
            itemManager.saveOrEdit(newItem);

        } else {
            Loan previousLoan = getById(newLoan.getId());
            Item previousItem = previousLoan.getItem();

            String editSql = "UPDATE loan SET item_id = ?, specification = ?, "
                    + "lent_to_me = ?, person_id = ?, since = ?, until = ? where id = ?";

            jdbcTemplate.update(editSql, newItem.getId(), newLoan.getSpecification(),
                    newLoan.isLentToMe(), newLoan.getPerson().getId(), newLoan.getStartDate(),
                    newLoan.getReturnDate(), newLoan.getId());

            if (!previousItem.getId().equals(newItem.getId())) {
                previousItem.setIsBorrowed(false);
                newItem.setIsBorrowed(true);

                itemManager.saveOrEdit(previousItem);
                itemManager.saveOrEdit(newItem);
            }
        }
    }

    @Override
    public List<Loan> getByPerson(Person person) {
         String sql = "SELECT \n"
                + "		id as loan_id,\n"
                + "		specification as loan_specification,\n"
                + "		lent_to_me as loan_lent_to_me,\n"
                + "		person_id as loan_person,\n"
                + "		item_id as loan_item_id,\n"
                + "		since as loan_since,\n"
                + "		until as loan_until\n"
                + "	FROM loan"
                + "     WHERE person_id = ?;";

        List<Loan> loans = jdbcTemplate.query(sql, new LoanRowMapper(), person.getId());
        if (loans.isEmpty()) {
            return null;
        }

        setItemById(loans);
        setPersonById(loans);
        return loans;
    }
    
    // other
    private void setItemById(List<Loan> loans) {
        loans.forEach((loan) -> {
            setItemById(loan);
        });
    }

    private void setItemById(Loan loan) {
        loan.setItem(itemManager.getById(loan.getItem().getId()));
    }

    private void setPersonById(List<Loan> loans) {
        loans.forEach((loan) -> {
            setPersonById(loan);
        });
    }

    private void setPersonById(Loan loan) {
        loan.setPerson(personManager.getById(loan.getPerson().getId()));
    }

    

}
