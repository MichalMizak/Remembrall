package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Person;

/**
 *
 * @author Mikey
 */
public interface ItemManager {

    List<Item> getItems();

    Item getById(Long id);

    void saveOrEdit(Item item);

    List<Item> getByCategory(Category category);

    void delete(Item item);

    List<Item> getNotBorrowedItems();

    List<Item> getBorrowedItems();

    List<Item> getByCategory(boolean lentByMeCheckBox, boolean lentToMeCheckBox, boolean notLentCheckBox, Category category);
    
    List<Item> getByPerson(Person person);
    
    List<Item> getByPerson(Person person, boolean isLentToMe);
}
