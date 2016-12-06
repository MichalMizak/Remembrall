package sk.upjs.paz1c.nezabudal.dao;

import sk.upjs.paz1c.nezabudal.entity.Category;
import java.util.List;

/**
 *
 * @author Mikey
 */
public interface CategoryDao {
    
    public List<Category> getCategories();
    
    public Category getById(Long id);
     
    public List<String> getAttributes();
    
    public void saveOrEdit(Category kategoria);  
    
    public void delete(Category category);
}
