package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.PersonDao;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Person;

/**
 *
 * @author Mikey
 */
public interface PersonManager extends PersonDao {

    List<Person> getPersons();

    Person getById(Long id);

    void saveOrEdit(Person person);

    void delete(Person person);

    public Person getByItem(Item item);
}
