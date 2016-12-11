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

    @Override
    public Attribute getById(Long id) {
        String sql = SqlQueries.GET_ATTRIBUTE_BY_ID;
        return jdbcTemplate.queryForObject(sql, new AttributeRowMapper(), id);
    }

    @Override
    public void saveOrEdit(Attribute attribute, Item item, Category category) {
        String saveNameSql = "INSERT INTO attribute_names VALUES (?, ?, ?)";
        String saveValueSql = "INSERT INTO attribute_values VALUES(?, ?, ?, ?)";

        String editNameSql = "UPDATE attribute_names SET name = ? WHERE id = ? and category_id = ?";
        
        if (attribute.getId() == null) {
            jdbcTemplate.update(saveNameSql, null, category.getId(), attribute.getName());
        } else {
            jdbcTemplate.update(editNameSql, attribute.getName(), attribute.getId(), category.getId());
            if (item != null) {
                jdbcTemplate.update(saveValueSql, null, attribute.getId(), item.getId(), attribute.getValue());
            }
        }

    }

    @Override
    public void delete(Attribute attribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Attribute> getByCategory(Category category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
