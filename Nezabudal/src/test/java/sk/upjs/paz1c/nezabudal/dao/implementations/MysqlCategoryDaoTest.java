package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public class MysqlCategoryDaoTest {

    private MysqlCategoryDao instance = new MysqlCategoryDao();

    @Test
    public void testGetCategories() {
        System.out.println("getCategories");

        List<Category> result = instance.getCategories();

        assertNotEquals(null, result);
    }

    /**
     * Test of getById method, of class MysqlCategoryDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 1L;

        Category result = instance.getById(id);

        System.out.println(result);
        assertNotEquals(null, result);
        // TODO review the generated test code and remove the default call to fail.
        //    fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrEdit method, of class MysqlCategoryDao.
     */
    @Test
    public void testSave() {
        System.out.println("save");

        List<Category> beforeUpdate = instance.getCategories();

        Category category = new Category();
        category.setTitle("Poznámky");
        instance.saveOrEdit(category);

        List<Category> afterUpdate = instance.getCategories();

        assertEquals(beforeUpdate.size(), afterUpdate.size() - 1);
    }

    /**
     * Test of saveOrEdit method, of class MysqlCategoryDao.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");

        Category beforeUpdate = instance.getById(3L);
        beforeUpdate.setTitle("Peniaze");
        instance.saveOrEdit(beforeUpdate);

        Category afterUpdate = instance.getById(3L);

        assertEquals(afterUpdate.getTitle(), "Peniaze");
    }

    /**
     * Test of delete method, of class MysqlCategoryDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");

        List<Category> beforeUpdate = instance.getCategories();

        Category category = instance.getById(4L);
        instance.delete(category);

        List<Category> afterUpdate = instance.getCategories();

        assertEquals(beforeUpdate.size(), afterUpdate.size() + 1);
    }

}
