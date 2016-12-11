package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public class DummyAttributeDao implements AttributeDao {

    List<Attribute> attributes = new ArrayList<>();

    public DummyAttributeDao() {
        attributes.add(new Attribute("Názov", ""));
        attributes.add(new Attribute("Od", ""));
        attributes.add(new Attribute("Do", ""));
        attributes.add(new Attribute("Osoba", ""));
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Attribute getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrEdit(Attribute attribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Attribute attribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Attribute> getByCategory(Category category) {
        List<Attribute> list = new ArrayList<>();
        list.add(new Attribute("attr1", ""));
        list.add(new Attribute("attr2", ""));
        list.add(new Attribute("attr3", ""));
        list.add(new Attribute("attr4", ""));
        
        return list;
   }
}
