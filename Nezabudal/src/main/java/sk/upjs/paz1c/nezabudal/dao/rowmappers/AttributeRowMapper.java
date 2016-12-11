package sk.upjs.paz1c.nezabudal.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.entity.Attribute;

/**
 *
 * @author Mikey
 */
public class AttributeRowMapper implements RowMapper<Attribute>{

    @Override
    public Attribute mapRow(ResultSet rs, int i) throws SQLException {
        Attribute attribute = new Attribute();
        
        attribute.setId(rs.getLong("attribute_id"));
        attribute.setName(rs.getString("attribute_name"));
        attribute.setValue(rs.getString("attribute_value"));
        
        return attribute;
    }
    
}
