package sk.upjs.paz1c.nezabudal.dummy.data;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;


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

    @Override
    public Attribute getById(Long id) {
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

    @Override
    public void saveOrEditName(Attribute attribute, Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveOrEditValue(Attribute attribute, Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Attribute> getByItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
