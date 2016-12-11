package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;

/**
 *
 * @author Mikey
 */
    
public class CategoryComboBoxModel extends DefaultComboBoxModel<Category>  {
    
   private CategoryManager categoryManager = ObjectFactory.INSTANCE.getCategoryManager();

    public CategoryComboBoxModel() {        
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
     
        List<Category> categories = categoryManager.getCategories();
        for(Category category : categories) {
            addElement(category);
        }        
}
}


