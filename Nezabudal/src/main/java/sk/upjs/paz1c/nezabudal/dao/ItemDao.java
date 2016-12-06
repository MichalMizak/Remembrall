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

    void saveOrUpdate(Item item);
    
    List<Item> getByCategory(Category category);  
    
    List<Item> getOwnedItems();
    
    List<Item> getNotOwnedItems();   
    
    void delete(Item item);

}
