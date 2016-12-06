package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyItemDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public class ItemComboBoxModel extends DefaultComboBoxModel<Item>{

/**
 *
 * @author Mikey
 */  
    private ItemDao itemDao = DummyItemDao.INSTANCE;

    public ItemComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Item> items = itemDao.getItems();
        
        for(Item item : items) {
            addElement(item);
        }        
    }
}




