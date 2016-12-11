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

    public List<Attribute> getAttributes();

    public Attribute getById(Long id);

    public void saveOrEdit(Attribute attribute);

    public void saveOrEdit(List<Attribute> attributes);

    public void delete(Attribute attribute);

    public List<Attribute> getByCategory(Category category);

    public Attribute getByItemAndTitle(Item item, String title);

    public List<String> getAttributeNames(List<Attribute> attributes);

    public List<String> getAttributeValues(List<Attribute> attributes);
}
