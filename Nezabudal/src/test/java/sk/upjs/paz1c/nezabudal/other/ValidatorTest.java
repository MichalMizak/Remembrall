package sk.upjs.paz1c.nezabudal.other;

import java.time.LocalDateTime;
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
        String expResult = "Zadajte názov";
        String result = Validator.validateItem(name, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of validateLoan method, of class Validator.
     */
    @Test
    public void testValidateLoan() {
        System.out.println("validateLoan");
        Item item = new Item();
        item.setIsBorrowed(true);
        
        String description = "";
        String person = "";
        String expResult = "Predmet nesmie byť zapožičaný";
        String result = Validator.validateLoan(item, false, person);
        assertEquals(expResult, result);  
    
    }

    /**
     * Test of validateLoanSince method, of class Validator.
     */
    @Test
    public void testValidateLoanSince() {
        System.out.println("validateLoanSince");
        String since = null;
        Object expResult = null;
        Object result = Validator.validateLoanSince("11.11.1234 22:10");
        System.out.println(((LocalDateTime)result).getHour() + ":" + ((LocalDateTime)result).getMinute());
        assertNotEquals(expResult, result);
    }

    /**
     * Test of validateLoanUntil method, of class Validator.
     */
    @Test
    public void testValidateLoanUntil() {
        System.out.println("validateLoanSince");
        String since = null;
        Object expResult = null;
        Object result = Validator.validateLoanUntil("11.11.1234 22:10");
        System.out.println(((LocalDateTime)result).getHour() + ":" + ((LocalDateTime)result).getMinute());
        assertNotEquals(expResult, result);
    }

    
}
