package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public interface CategoryManager {
    
    public List<Category> getCategories();
    
    public Category getById(Long id);
         
    public void saveOrEdit(Category kategoria);  
    
    public void delete(Category category);
}