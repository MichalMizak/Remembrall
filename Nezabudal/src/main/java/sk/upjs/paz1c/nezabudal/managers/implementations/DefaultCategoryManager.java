package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;

/**
 *
 * @author Mikey
 */
public class DefaultCategoryManager implements CategoryManager{

    CategoryDao categoryDao = ObjectFactory.INSTANCE.getCategoryDao();
    
    @Override
    public List<Category> getCategories() {
       return  categoryDao.getCategories();
    }

    @Override
    public Category getById(Long id) {
       return categoryDao.getById(id);
    }

    @Override
    public void saveOrEdit(Category kategoria) {
        categoryDao.saveOrEdit(kategoria);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
    
}
