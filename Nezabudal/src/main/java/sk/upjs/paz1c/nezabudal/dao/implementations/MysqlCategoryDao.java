package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.CategoryRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class MysqlCategoryDao implements CategoryDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    @Override
    public List<Category> getCategories() {
        String sql = "SELECT id as category_id, title as category_title from category;";
        return jdbcTemplate.query(sql, new CategoryRowMapper());
    }

    @Override
    public Category getById(Long id) {
        String sql = "SELECT id as category_id, title as category_title from category where id = ?";
        return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), id);
    }

    @Override
    public void saveOrEdit(Category category) {
        if (category.getId() == null) {
            String sql = "INSERT INTO category VALUES (?, ?)";
            jdbcTemplate.update(sql, null, category.getTitle());
        } else {
            String sql = "UPDATE category SET title = ? WHERE id = ?";
            jdbcTemplate.update(sql, category.getTitle(), category.getId());
        }
    }

    @Override
    public void delete(Category category) {
        String sql = "DELETE FROM category WHERE id = ?";
        jdbcTemplate.update(sql, category.getId());
    }

}
