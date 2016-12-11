package sk.upjs.paz1c.nezabudal.managers;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/**
 *
 * @author Mikey
 */
public interface AttributeManager {

    public Attribute getById(Long id);

    public void saveOrEdit(Attribute attribute, Item item, Category category);
    
    public void saveOrEditNames(List<Attribute> attributes, Category category);

    public void saveOrEdit(List<Attribute> attributes, Item item, Category category);

    public void delete(Attribute attribute);

    public List<Attribute> getByCategory(Category category);

    public Attribute getByItemAndTitle(Item item, String title);

    public List<String> getAttributeNames(List<Attribute> attributes);

    public List<String> getAttributeValues(List<Attribute> attributes);

}
