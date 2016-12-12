package sk.upjs.paz1c.nezabudal.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Item;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;


/**
 *
 * @author Mikey
 */
public class ItemRowMapper implements RowMapper<Item>{

    private CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();
    
    public ItemRowMapper() {
    }
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        
        item.setId(rs.getLong("item_id"));
        item.setName(rs.getString("item_name"));
        item.setIsBorrowed(rs.getBoolean("item_is_borrowed"));
        item.setDescription(rs.getString("item_description"));
        
        item.setCategory(categoryRowMapper.mapRow(rs, rowNum));     
        
        return item;
    }
  
}
