package sk.upjs.paz1c.nezabudal.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.entity.Category;

/**
 *
 * @author Mikey
 */
public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int i) throws SQLException {
        Category category = new Category();
        
        category.setId(rs.getLong("category_id"));
        category.setTitle(rs.getString("category_title"));
        
        return category;
    }
    
}
