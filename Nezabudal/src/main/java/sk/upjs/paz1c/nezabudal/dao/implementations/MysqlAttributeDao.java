package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.AttributeRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.other.SqlQueries;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;

/**
 *
 * @author Mikey
 */
public class MysqlAttributeDao implements AttributeDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    /**
     * returns only the attributes that have a value assigned to them
     *
     * @param id
     * @return
     */
    @Override
    public Attribute getByNameId(Long id) {
        String sql = SqlQueries.GET_ATTRIBUTE_BY_NAME_ID;
        return jdbcTemplate.queryForObject(sql, new AttributeRowMapper(), id);
    }

    @Override
    public void saveOrEditName(Attribute attribute, Category category) {
        String saveNameSql = "INSERT INTO attribute_names VALUES (?, ?, ?)";

        String editNameSql = "UPDATE attribute_names SET name = ? WHERE id = ?";

        if (attribute.getNameId() == null) {
            jdbcTemplate.update(saveNameSql, null, category.getId(), attribute.getName());
        } else {
            jdbcTemplate.update(editNameSql, attribute.getName(), attribute.getNameId());
        }
    }

    @Override
    public void saveOrEditValue(Attribute attribute, Item item) {
        String saveValueSql = "INSERT INTO attribute_values VALUES(?, ?, ?, ?)";
        String editValueSql = "UPDATE attribute_values SET value = ? WHERE id = ?";

        if (attribute.getValueId() == null || attribute.getValueId() == 0) {
            jdbcTemplate.update(saveValueSql, null, attribute.getNameId(), item.getId(), attribute.getValue());
        } else {
            jdbcTemplate.update(editValueSql, attribute.getValue(), attribute.getValueId());
        }
    }

    /**
     * Is not functional when there are items in a category
     *
     * @param attribute
     */
    @Override
    public void delete(Attribute attribute) {
        String sql = "DELETE FROM attribute_names WHERE id = ?";
        jdbcTemplate.update(sql, attribute.getNameId());
    }

    @Override
    public List<Attribute> getByCategory(Category category) {

        return jdbcTemplate.query(SqlQueries.GET_ATTRIBUTES_BY_CATEGORY,
                new AttributeRowMapper(), category.getId());
    }

    @Override
    public List<Attribute> getByItem(Item item) {
        List<Attribute> itemAttributes = new ArrayList<>();
        itemAttributes = jdbcTemplate.query(SqlQueries.GET_ATTRIBUTES_BY_ITEM,
                new AttributeRowMapper(), item.getId());
//        List<Attribute> categoryAttributes = getByCategory(item.getCategory());
//
//        if (item.getAttributes().size() != categoryAttributes.size()) {
//            for (Attribute categoryAttribute : categoryAttributes) {
//                boolean contains = false;
//                for (Attribute itemAttribute : itemAttributes) {
//                    if (itemAttribute.getNameId().equals(categoryAttribute.getNameId())) {
//                        contains = true;
//                    }
//                }
//
//                if (!contains) {
//                    itemAttributes.add(categoryAttribute);
//                }
//            }
//        }

        return itemAttributes;
    }

    @Override
    public Attribute getByNameId(Long nameId, Item item) {

        List<Attribute> attribute = jdbcTemplate.query(SqlQueries.GET_ATTRIBUTE_BY_NAME_ID_AND_ITEM,
                new AttributeRowMapper(), nameId, item.getId());
        if (attribute.isEmpty()) {
            return getByNameId(nameId);
        }
        return attribute.get(0);
    }
}
