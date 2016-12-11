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
        
        Attribute attribute = instance.getById(1L);
        
        System.out.println(attribute);
        assertNotEquals(null, attribute);
    }
    
}
