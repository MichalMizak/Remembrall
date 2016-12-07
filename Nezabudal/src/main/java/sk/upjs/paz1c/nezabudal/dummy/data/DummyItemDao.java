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

    public DummyItemDao() {
        item = new Item();
        item.setItemDescription("Dummy item description");
        item.setItemName("Dummy item name");
        item.setCategory(ObjectFactory.INSTANCE.getCategoryDao().getById(0L));
        item.setItemState("No problem");
        item.setLoan(ObjectFactory.INSTANCE.getLoanDao().getById(0L));

        List<String> list = new ArrayList<>();
        list.add("attr1");
        list.add("attr2");
        list.add("attr3");
        list.add("attr4");

        item.setAttributeValues(list);

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

        return getItems();
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
