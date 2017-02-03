package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.paz1c.nezabudal.dao.PersonDao;
import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.managers.PersonManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class MysqlPersonDaoTest {

    PersonDao personDao = new MysqlPersonDao();

    /**
     * Test of getPersons method, of class MysqlPersonDao.
     */
    @Test
    public void testGetPersons() {

        List<Person> result = personDao.getPersons();

        assertNotEquals(null, result);
    }

    /**
     * Test of getById method, of class MysqlPersonDao.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        Long id = 1L;

        Person result = personDao.getById(id);
        assertNotEquals(null, result);
    }

    /**
     * Test of saveOrEdit method, of class MysqlPersonDao.
     */
    @Test
    public void testSaveOrEdit() {
        System.out.println("saveOrEdit");
        Person person = personDao.getById(1L);
        person.setName("Nejka");

        personDao.saveOrEdit(person);
        assertEquals(person.getName(), "Nejka");
    }

    /**
     * Test of delete method, of class MysqlPersonDao.
     */
    @Test
    public void testDelete() {

        Person person = personDao.getById(3L);

        personDao.delete(person);
        
        assertEquals(null, personDao.getById(3L));
    }

}
