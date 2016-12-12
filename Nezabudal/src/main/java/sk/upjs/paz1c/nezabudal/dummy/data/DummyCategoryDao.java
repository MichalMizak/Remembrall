package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public class DummyCategoryDao implements CategoryDao {

    private Category category;
    private Category category2;
    private Category category3;

    public DummyCategoryDao() {

        category = new Category();
        category.setTitle("wat");
        List<Attribute> list = new ArrayList<>();
        list.add(new Attribute("attr1", ""));
        list.add(new Attribute("attr2", ""));
        list.add(new Attribute("attr3", ""));
        list.add(new Attribute("attr4", ""));

        category2 = new Category();
        category2.setTitle("wat2");
        List<Attribute> list2 = new ArrayList<>();
        list2.add(new Attribute("attr1", ""));
        list2.add(new Attribute("attr2", ""));
        list2.add(new Attribute("attr3", ""));

        category3 = new Category();
        category3.setTitle("wat3");
        List<Attribute> list3 = new ArrayList<>();
        list3.add(new Attribute("attr1", ""));
        list3.add(new Attribute("attr2", ""));
    }

    @Override
    public List<Category> getCategories() {
        List<Category> list = new ArrayList<>();
        list.add(category);
        list.add(category2);
        list.add(category3);
        return list;
    }

    @Override
    public Category getById(Long id) {
        if (id.equals(0L)) {
            return category;
        } else {
            return category2;
        }
    }

    @Override
    public Number saveOrEdit(Category kategoria) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category category) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
