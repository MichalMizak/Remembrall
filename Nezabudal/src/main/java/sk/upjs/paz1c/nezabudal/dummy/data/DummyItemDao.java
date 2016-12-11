package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;

/**
 *
 * @author Mikey
 */
public class DummyItemDao implements ItemDao {

    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();
    private Item item;
    private Item item2;

    public DummyItemDao() {

//        List<String> list = new ArrayList<>();
//        list.add("attr1");
//        list.add("attr2");
//        list.add("attr3");
//        list.add("attr4");
        Category category = ObjectFactory.INSTANCE.getCategoryManager().getById(0L);

        item = new Item("Dummy item name","Dummy item description",  true, category, attributeManager.getByCategory(category));
        Category category2 = ObjectFactory.INSTANCE.getCategoryManager().getById(1L);

        item2 = new Item( "Dummy item name 2", "Dummy item description 2", false, category2, attributeManager.getByCategory(category2));
    }

    @Override
    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item2);
        return list;
    }

    @Override
    public void saveOrUpdate(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getByCategory(Category category) {
        List<Item> list = new ArrayList<>();
        if (item.getCategory().equals(category)) {
            list.add(item);
        list.add(item);
        }
        if (item2.getCategory().equals(category)) {
            list.add(item2);
        }
        return list;
    }

    @Override
    public void delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getById(Long id) {
        return item;
    }

      @Override
    public List<Item> getBorrowedItems() {
        List<Item> list = getItems();
        
        for (Item item : list) {
            if (!item.isIsBorrowed())
                list.remove(item);
        }
        
        return list;
    }
    @Override
    public List<Item> getUnborrowedItems() {
        List<Item> list = getItems();
        
        for (Item item : list) {
            if (item.isIsBorrowed())
                list.remove(item);
        }
        
        return list;
    }

}
