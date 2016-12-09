package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyItemDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class ItemComboBoxModel extends DefaultComboBoxModel<Item> {

    /**
     *
     * @author Mikey
     */
    private ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    public ItemComboBoxModel(Category category) {
        refresh(category);
    }

    public ItemComboBoxModel() {
        refresh();
    }

    public void refresh(Category category) {
        removeAllElements();

        List<Item> items = itemManager.getByCategory(category);

        for (Item item : items) {
            addElement(item);
        }
    }

    private void refresh() {
        removeAllElements();

        List<Item> items = itemManager.getItems();

        for (Item item : items) {
            addElement(item);
        }
    }
}
