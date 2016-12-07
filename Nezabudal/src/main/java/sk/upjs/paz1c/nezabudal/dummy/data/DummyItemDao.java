package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class DummyItemDao implements ItemDao {

    private Item item;
    private Item item2;

    public DummyItemDao() {

//        List<String> list = new ArrayList<>();
//        list.add("attr1");
//        list.add("attr2");
//        list.add("attr3");
//        list.add("attr4");
        Category category = ObjectFactory.INSTANCE.getCategoryDao().getById(0L);

        item = new Item("Dummy item description", "Dummy item name", "No problem", true, category, category.getAttributes());
        Category category2 = ObjectFactory.INSTANCE.getCategoryDao().getById(1L);

        item2 = new Item("Dummy item description 2", "Dummy item name 2", "No problem 2", false, category2, category2.getAttributes());
    }

    @Override
    public List<Item> getItems() {
        List<Item> list = new ArrayList<>();
        list.add(item);
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
        }
        if (item2.getCategory().equals(category)) {
            list.add(item2);
        }
        return list;
    }

    @Override
    public List<Item> getOwnedItems() {
        return null;
    }

    @Override
    public List<Item> getNotOwnedItems() {
        return getItems();
    }

    @Override
    public void delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getById(Long id) {
        return item;
    }

}
