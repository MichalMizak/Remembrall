package sk.upjs.paz1c.nezabudal.dao;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public interface ItemDao {

    List<Item> getItems();

    Item getById(Long id);

    void saveOrUpdate(Item item);

    void delete(Item item);

    List<Item> getByCategory(Category category);

    List<Item> getBorrowedItems();
    
    List<Item> getUnborrowedItems();

}
