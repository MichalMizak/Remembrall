package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

        List<Category> list = jdbcTemplate.query(sql, new CategoryRowMapper(), id);
        if (list.size() > 0) {
            return list.get(0);
        } else 
            return null;
    }

    @Override
    public Number saveOrEdit(Category category) {
        if (category.getId() == null) {
            String sql = "INSERT INTO category VALUES (?, ?)";

            // need to get the generated value
            final PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                    final PreparedStatement ps = connection.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, null);
                    ps.setString(2, category.getTitle());
                    return ps;
                }
            };
            final KeyHolder holder = new GeneratedKeyHolder();

            jdbcTemplate.update(psc, holder);

            return holder.getKey();
            //jdbcTemplate.update(sql, null, category.getTitle());
        } else {
            String sql = "UPDATE category SET title = ? WHERE id = ?";
            jdbcTemplate.update(sql, category.getTitle(), category.getId());
            return null;
        }
    }

    @Override
    public void delete(Category category) {
        if (category == null) {
            return;
        }
        String sql = "DELETE FROM category WHERE id = ?";
        jdbcTemplate.update(sql, category.getId());
    }

}
