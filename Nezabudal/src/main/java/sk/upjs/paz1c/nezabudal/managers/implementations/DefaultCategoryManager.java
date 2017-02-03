package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;

/**
 *
 * @author Mikey
 */
public class DefaultCategoryManager implements CategoryManager {

    CategoryDao categoryDao = ObjectFactory.INSTANCE.getCategoryDao();
    AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();

    @Override
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }

    @Override
    public Category getById(Long id) {
        return categoryDao.getById(id);
    }

    @Override
    public void saveOrEdit(Category category, List<Attribute> attributes) {
        categoryDao.saveOrEdit(category);

        attributeManager.saveOrEditName(attributes, category);
     }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }
}
