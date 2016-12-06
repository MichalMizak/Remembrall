package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
    
public class CategoryComboBoxModel extends DefaultComboBoxModel<Category>  {
   private CategoryDao categoryDao = DummyCategoryDao.INSTANCE;

    public CategoryComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Category> categories = categoryDao.getCategories();
        
        for(Category category : categories) {
            addElement(category);
        }        
    }
}


