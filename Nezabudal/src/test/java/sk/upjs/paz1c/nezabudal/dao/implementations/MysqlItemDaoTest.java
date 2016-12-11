package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public class MysqlItemDaoTest {

    MysqlItemDao instance = new MysqlItemDao();

    /**
     * Test of getItems method, of class MysqlItemDao.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        List<Item> result = instance.getItems();
        System.out.println(result);
        assertNotEquals(null, result);
    }

    /**
     * Test of getById method, of class MysqlItemDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 1L;
        Item result = instance.getById(id);
        System.out.println(result);
        assertNotEquals(null, result);
    }

    /**
     * Test of saveOrUpdate method, of class MysqlItemDao.
     */
    @Test
    public void testSaveOrUpdate() {
        System.out.println("saveOrUpdate");
        Item item = null;
        instance.saveOrUpdate(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MysqlItemDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Item item = null;
        instance.delete(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getByCategory method, of class MysqlItemDao.
     */
    @Test
    public void testGetByCategory() {
        System.out.println("getByCategory");
        Category category = null;
        List<Item> expResult = null;
        List<Item> result = instance.getByCategory(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBorrowedItems method, of class MysqlItemDao.
     */
    @Test
    public void testGetBorrowedItems() {
        System.out.println("getBorrowedItems");
        List<Item> expResult = null;
        List<Item> result = instance.getBorrowedItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnborrowedItems method, of class MysqlItemDao.
     */
    @Test
    public void testGetUnborrowedItems() {
        System.out.println("getUnborrowedItems");
        List<Item> expResult = null;
        List<Item> result = instance.getUnborrowedItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
