package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;

/**
 *
 * @author Mikey
 */
public class MysqlLoanDaoTest {

    private final MysqlLoanDao instance = new MysqlLoanDao();

    /**
     * Test of getLoans method, of class MysqlLoanDao.
     */
    @Test
    public void testGetLoans() {
        System.out.println("getLoans");
        List<Loan> result = instance.getLoans();

        System.out.println(result);
        assertEquals(1, result.size());
    }

    /**
     * Test of getByItem method, of class MysqlLoanDao.
     */
    @Test
    public void testGetByItem() {
        System.out.println("getByItem");
        Item item = new Item();
        item.setId(1L);

        Loan result = instance.getByItem(item);
        assertEquals(result.getReturnDate(), null);
    }

    /**
     * Test of getById method, of class MysqlLoanDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        for (int i = 1; i < 10; i++) {
            Loan result = instance.getById(new Long(i));
            if (result != null) {
                assertEquals(new Long(i), result.getId());
            }
        }
    }
}
