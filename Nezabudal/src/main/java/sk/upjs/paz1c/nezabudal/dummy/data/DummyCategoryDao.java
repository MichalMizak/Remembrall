package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public enum DummyCategoryDao implements CategoryDao {

    INSTANCE;

    private Category category;

    private DummyCategoryDao() {

        category = new Category();
        category.setTitle("wat");
        List<String> list = new ArrayList<>();
        list.add("attr1");
        list.add("attr2");
        list.add("attr3");
        list.add("attr4");
        category.setAttributes(list);
    }

    @Override
    public List<Category> getCategories() {
        List<Category> list2 = new ArrayList<>();
        list2.add(category);
        return list2;
    }

    @Override
    public Category getById(Long id) {
        return category;
    }

    @Override
    public List<String> getAttributes() {
        return category.getAttributes();
    }

    @Override
    public void saveOrEdit(Category kategoria) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category category) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
