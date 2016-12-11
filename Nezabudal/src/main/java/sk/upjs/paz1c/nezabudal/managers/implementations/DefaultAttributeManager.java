package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;

/**
 *
 * @author Mikey
 */
public class DefaultAttributeManager implements AttributeManager {

    AttributeDao attributeDao = ObjectFactory.INSTANCE.getAttributeDao();

    @Override
    public Attribute getById(Long id) {
        return attributeDao.getById(id);
    }

    @Override
    public void saveOrEdit(Attribute attribute, Item item, Category category) {
        attributeDao.saveOrEdit(attribute, item, category);
    }

    
    @Override
    public void saveOrEdit(List<Attribute> attributes, Item item, Category category) {
        for (Attribute attribute : attributes) {
            saveOrEdit(attribute, item, category);
        }
    }
    
    @Override
    public void saveOrEditNames(List<Attribute> attributes, Category category) {
        saveOrEdit(attributes, null, category);
    }

    @Override
    public void delete(Attribute attribute) {
        attributeDao.delete(attribute);
    }

    @Override
    public List<Attribute> getByCategory(Category category) {
        return attributeDao.getByCategory(category);
    }

    @Override
    public List<String> getAttributeNames(List<Attribute> attributes) {
        List<String> list = new ArrayList<>();
        for (Attribute attribute : attributes) {
            list.add(attribute.getName());
        }
        return list;
    }

    @Override
    public List<String> getAttributeValues(List<Attribute> attributes) {
        List<String> list = new ArrayList<>();
        for (Attribute attribute : attributes) {
            list.add(attribute.getValue());
        }
        return list;
    }


    @Override
    public Attribute getByItemAndTitle(Item item, String title) {
        List<Attribute> attributes = item.getAttributes();

        for (Attribute attribute : attributes) {
            if (title.equals(attribute.getName())) {
                return attribute;
            }
        }

        return null;
    }

}
