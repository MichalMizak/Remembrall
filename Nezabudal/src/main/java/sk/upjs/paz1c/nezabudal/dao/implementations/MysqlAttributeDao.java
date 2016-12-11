package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.nezabudal.dao.AttributeDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.AttributeRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.other.SqlQueries;

/**
 *
 * @author Mikey
 */
public class MysqlAttributeDao implements AttributeDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    /**
     * returns only the attributes that have a value assigned to them
     * @param id
     * @return
     */
    @Override
    public Attribute getById(Long id) {
        String sql = SqlQueries.GET_ATTRIBUTE_BY_NAME_ID;
        return jdbcTemplate.queryForObject(sql, new AttributeRowMapper(), id);
    }

    @Override
    public void saveOrEdit(Attribute attribute, Item item, Category category) {
        String saveNameSql = "INSERT INTO attribute_names VALUES (?, ?, ?)";
        String saveValueSql = "INSERT INTO attribute_values VALUES(?, ?, ?, ?)";

        String editNameSql = "UPDATE attribute_names SET name = ? WHERE id = ?";
        String editValueSql = "UPDATE attribute_values SET value = ? WHERE id = ?";

        if (attribute.getNameId() == null) {
            jdbcTemplate.update(saveNameSql, null, category.getId(), attribute.getName());
        } else {
            jdbcTemplate.update(editNameSql, attribute.getName(), attribute.getNameId());
            if (item != null) {
                if (attribute.getValueId() == null) {
                    jdbcTemplate.update(saveValueSql, null, attribute.getNameId(), item.getId(), attribute.getValue());
                } else {
                    jdbcTemplate.update(editValueSql, attribute.getValue(), attribute.getValueId());
                }
            }
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

        String sql = "SELECT \n"
                + "null as attribute_value_id,\n"
                + "    null as attribute_value,\n"
                + "    id as attribute_name_id,\n"
                + "    name as attribute_name \n"
                + "		from attribute_names\n"
                + "            where category_id = ?;";

        return jdbcTemplate.query(sql, new AttributeRowMapper(), category.getId());
    }

}
