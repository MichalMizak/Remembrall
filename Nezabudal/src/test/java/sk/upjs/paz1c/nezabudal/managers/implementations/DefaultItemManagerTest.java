package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class DefaultItemManagerTest {

    /**
     * Test of getByCategory method, of class DefaultItemManager.
     */
    @Test
    public void testGetByCategory() {
        System.out.println("getByCategory");
        boolean lentByMeCheckBox = false;
        boolean lentToMeCheckBox = false;
        boolean notLentCheckBox = false;
        CategoryManager categoryManager = ObjectFactory.INSTANCE.getCategoryManager();
        LoanManager loanManager = ObjectFactory.INSTANCE.getLoanManager();

        Category category = categoryManager.getCategories().get(0);

        DefaultItemManager instance = new DefaultItemManager();
        List<Item> expResult = null;

        List<Item> result = instance.getByCategory(lentByMeCheckBox, lentToMeCheckBox, notLentCheckBox, category);

        if (result == null || result.size() == 0) {
            assertTrue(true);
        }
        for (Item item : result) {
            assertEquals(!item.isIsBorrowed(), notLentCheckBox);
            if (item.isIsBorrowed()) {
                assertTrue(loanManager.getByItem(item).isLentToMe() == lentToMeCheckBox ||
                        !loanManager.getByItem(item).isLentToMe() == lentByMeCheckBox);
            }
        }

    }

}
