package sk.upjs.paz1c.nezabudal.dao;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Person;

/**
 *
 * @author Mikey
 */
public interface PersonDao {

    List<Person> getPersons();

    Person getById(Long id);

    void saveOrEdit(Person person);

    void delete(Person person);
}
