package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public interface AttributeManager {

    public Attribute getByNameId(Long nameId);

    public Attribute getByNameId(Long nameId, Item item);

    public void saveOrEditValue(Attribute attribute, Item item);

    public void saveOrEditValue(List<Attribute> attributes, Item item);

    public void saveOrEditName(Attribute attribute, Category category);

    public void saveOrEditName(List<Attribute> attributes, Category category);

    public void delete(Attribute attribute);

    public List<Attribute> getByCategory(Category category);

    public List<Attribute> getByItem(Item item);

    public Attribute getByTitle(Item item, String title);

    public List<String> getAttributeNames(List<Attribute> attributes);

    public List<String> getAttributeValues(List<Attribute> attributes);

}
