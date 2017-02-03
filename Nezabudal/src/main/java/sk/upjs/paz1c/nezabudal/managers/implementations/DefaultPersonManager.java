package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.PersonDao;
import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.managers.PersonManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class DefaultPersonManager implements PersonManager {

    private PersonDao personDao = ObjectFactory.INSTANCE.getPersonDao();

    @Override
    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public void saveOrEdit(Person person) {
        personDao.saveOrEdit(person);
    }

    @Override
    public void delete(Person person) {
        personDao.delete(person);
    }
}
