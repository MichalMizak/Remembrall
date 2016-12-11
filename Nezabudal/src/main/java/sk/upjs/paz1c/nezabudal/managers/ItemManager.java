package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public interface ItemManager {

    List<Item> getItems();

    Item getById(Long id);

    void saveOrUpdate(Item item);

    List<Item> getByCategory(Category category);

    void delete(Item item);

    List<Item> getUnborrowedItems();

    List<Item> getItemsBorrowedToMe();

    List<Item> getItemsLentByMe();
}
