package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
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
        List<String> list = new ArrayList<>();
        list.add("attr1");
        list.add("attr2");
        list.add("attr3");
        list.add("attr4");
        category.setAttributes(list);

        category2 = new Category();
        category2.setTitle("wat2");
        List<String> list2 = new ArrayList<>();
        list2.add("attr1");
        list2.add("attr2");
        list2.add("attr3");
        category2.setAttributes(list2);
        
        
        category3= new Category();
        category3.setTitle("wat3");
        List<String> list3 = new ArrayList<>();
        list3.add("attr1");
        list3.add("attr2");
        category3.setAttributes(list2);
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
    public void saveOrEdit(Category kategoria) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category category) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
