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

    void saveOrEdit(Item item);

    void delete(Item item);

    List<Item> getByCategory(Category category);

    /**
     * returns items that are borrowed/ not borrowed depending on @param
     * isBorrowed
     *
     * @return
     */
    List<Item> getItems(boolean isBorrowed);
}
