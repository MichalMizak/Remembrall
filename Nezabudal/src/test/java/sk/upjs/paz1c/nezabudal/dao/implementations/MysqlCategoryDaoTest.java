package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

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
        List<Category> items = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            Category item = instance.getById(new Long(i));
            if (item != null) {
                items.add(item);
            }

        }
        System.out.println(items);
        assertTrue(items.size() > 0);
    }

    /**
     * Test of saveOrEdit method, of class MysqlCategoryDao.
     */
    //@Test
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

        Category beforeUpdate = instance.getById(2L);
        String title = beforeUpdate.getTitle();
        
        beforeUpdate.setTitle("Peniaze");
        instance.saveOrEdit(beforeUpdate);
        
        beforeUpdate.setTitle(title);
        instance.saveOrEdit(beforeUpdate);

        assertEquals(beforeUpdate.getTitle(), title);
    }

    /**
     * Test of delete method, of class MysqlCategoryDao.
     */
   // @Test
    public void testDelete() {
        System.out.println("delete");

        List<Category> beforeUpdate = instance.getCategories();

        Category category = instance.getById(4L);
        instance.delete(category);

        List<Category> afterUpdate = instance.getCategories();

        assertEquals(beforeUpdate.size(), afterUpdate.size() + 1);
    }

}
