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
    public Attribute getByNameId(Long id) {
        return attributeDao.getByNameId(id);
    }

    @Override
    public void saveOrEditValue(Attribute attribute, Item item) {
        attributeDao.saveOrEditValue(attribute, item);
    }

    @Override
    public void saveOrEditValue(List<Attribute> attributes, Item item) {
        for (Attribute attribute : attributes) {
            saveOrEditValue(attribute, item);
        }
    }

    @Override
    public void saveOrEditName(List<Attribute> newAttributes, Category category) {
        List<Attribute> categoryAttributes = getByCategory(category);

        for (Attribute categoryAttribute : categoryAttributes) {
            boolean contains = false;

            for (Attribute attribute : newAttributes) {

                if (categoryAttribute.getNameId().equals(attribute.getNameId())) {
                    contains = true;
                }
            }

            if (!contains) {
                delete(categoryAttribute);
            }
        }

        for (Attribute attribute : newAttributes) {
            saveOrEditName(attribute, category);
        }
    }

    @Override
    public void saveOrEditName(Attribute attribute, Category category) {
        attributeDao.saveOrEditName(attribute, category);
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
    public Attribute getByTitle(Item item, String title) {
        List<Attribute> attributes = item.getAttributes();

        for (Attribute attribute : attributes) {
            if (title.equals(attribute.getName())) {
                return attribute;
            }
        }
        return null;
    }

    @Override
    public List<Attribute> getByItem(Item item) {
        return attributeDao.getByItem(item);
    }

    @Override
    public Attribute getByNameId(Long nameId, Item item) {
        return attributeDao.getByNameId(nameId, item);
    }

}
