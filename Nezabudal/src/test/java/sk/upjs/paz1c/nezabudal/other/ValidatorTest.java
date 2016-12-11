package sk.upjs.paz1c.nezabudal.other;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public class ValidatorTest {
    
    public ValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validateCategory method, of class Validator.
     */
    @Test
    public void testValidateCategory() {
        System.out.println("validateCategory");
        Category category = null;
        String title = "";
        String expResult = "";
        String result = Validator.validateCategory(category, title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of categoryHasNoItems method, of class Validator.
     */
    @Test
    public void testCategoryHasNoItems() {
        System.out.println("categoryHasNoItems");
        Category category = null;
        String expResult = "";
        String result = Validator.categoryHasNoItems(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateItem method, of class Validator.
     */
    @Test
    public void testValidateItem() {
        System.out.println("validateItem");
        String name = "";
        String description = "";
        Category selectedCategory = null;
        List<Attribute> list = null;
        String expResult = "";
        String result = Validator.validateItem(name, description, selectedCategory, list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLoan method, of class Validator.
     */
    @Test
    public void testValidateLoan() {
        System.out.println("validateLoan");
        Item item = null;
        String description = "";
        String person = "";
        String expResult = "";
        String result = Validator.validateLoan(item, description, person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLoanSince method, of class Validator.
     */
    @Test
    public void testValidateLoanSince() {
        System.out.println("validateLoanSince");
        String since = "";
        Object expResult = null;
        Object result = Validator.validateLoanSince(since);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLoanUntil method, of class Validator.
     */
    @Test
    public void testValidateLoanUntil() {
        System.out.println("validateLoanUntil");
        String until = "";
        Object expResult = null;
        Object result = Validator.validateLoanUntil(until);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateLoanBorrowedToMe method, of class Validator.
     */
    @Test
    public void testValidateLoanBorrowedToMe() {
        System.out.println("validateLoanBorrowedToMe");
        String borrowedToMe = "";
        String expResult = "";
        String result = Validator.validateLoanBorrowedToMe(borrowedToMe);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
