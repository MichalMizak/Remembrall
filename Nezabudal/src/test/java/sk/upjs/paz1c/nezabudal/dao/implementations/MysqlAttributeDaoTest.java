package sk.upjs.paz1c.nezabudal.dao.implementations;

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
public class MysqlAttributeDaoTest {

    MysqlAttributeDao instance = new MysqlAttributeDao();

    @Test
    public void testGetById() {
        System.out.println("getById");

        Attribute attribute = instance.getById(2L);

        System.out.println(attribute);
        assertNotEquals(null, attribute);
    }

    @Test
    public void testGetByCategory() {
        System.out.println("getByCategory");

        Category category = new Category();
        category.setId(2L);

        List<Attribute> list = instance.getByCategory(category);

        System.out.println(list);
        assertEquals(list.size(), 2);
    }

    /**
     * Test of saveOrEdit method, of class MysqlAttributeDao.
     */
    @Test
    public void testSaveNewAttribute() {
        System.out.println("saveNewAttribute");

        Attribute attribute = new Attribute();
        attribute.setName("Množstvo");

        Category category = new Category();
        category.setId(2L);

        List<Attribute> beforeUpdate = instance.getByCategory(category);

        instance.saveOrEditName(attribute, category);

        List<Attribute> afterUpdate = instance.getByCategory(category);

        assertEquals(beforeUpdate.size(), afterUpdate.size() - 1);
    }

    @Test
    public void testEditAttributeName() {
        System.out.println("saveNewAttribute");

        Attribute attribute = new Attribute();
        attribute.setNameId(2L);
        attribute.setName("Autor");

        Category category = new Category();
        category.setId(2L);

        instance.saveOrEditName(attribute, category);

        Attribute attribute2 = instance.getById(2L);
        System.out.println(attribute2.getName());

        assertEquals("Autor", attribute2.getName());
    }

    @Test
    public void testSaveAttributeValue() {
        System.out.println("saveNewAttribute");

        Attribute attribute = new Attribute();
        attribute.setNameId(2L);
        attribute.setValueId(2L);
        attribute.setValue("J.K.Rowling");

        Item item = new Item();
        item.setId(1L);
        
        Category category = new Category();
        category.setId(2L);
        
        instance.saveOrEditValue(attribute, item);

        // test results manually reviewed in database
        // assertEquals("", item);

    }

    /**
     * Test of delete method, of class MysqlAttributeDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Attribute attribute = null;
        MysqlAttributeDao instance = new MysqlAttributeDao();
        instance.delete(attribute);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetByItem() {
        System.out.println("getByItem");
        
        Item item = new Item();
        
        item.setId(1L);
        
        List<Attribute> attributes = instance.getByItem(item);
        
        assertNotEquals(attributes, null);
    }
}
