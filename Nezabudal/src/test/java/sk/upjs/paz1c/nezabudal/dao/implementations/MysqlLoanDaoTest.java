package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        Long id = null;
        MysqlLoanDao instance = new MysqlLoanDao();
        Loan expResult = null;
        Loan result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MysqlLoanDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Loan loan = null;
        MysqlLoanDao instance = new MysqlLoanDao();
        instance.delete(loan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrEdit method, of class MysqlLoanDao.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        Loan loan = null;
        MysqlLoanDao instance = new MysqlLoanDao();
        instance.saveOrEdit(loan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
