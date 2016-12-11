package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.AttributeRowMapper;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.ItemRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.other.SqlQueries;

/**
 *
 * @author Mikey
 */
public class MysqlItemDao implements ItemDao {

    private JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    @Override
    public List<Item> getItems() {
        List<Item> itemList = jdbcTemplate.query(SqlQueries.GET_ALL_ITEMS, new ItemRowMapper());

        for (Item item : itemList) {
            item.setAttributes(jdbcTemplate.query(SqlQueries.GET_ATTRIBUTES_BY_ITEM, new AttributeRowMapper(), item.getId()));
        }

        return itemList;
    }

    @Override
    public List<Item> getByCategory(Category category) {

        List<Item> itemList = jdbcTemplate.query(SqlQueries.GET_ITEMS_BY_CATEGORY, new ItemRowMapper(), category.getId());

        for (Item item : itemList) {
            item.setAttributes(jdbcTemplate.query(SqlQueries.GET_ATTRIBUTES_BY_ITEM, new AttributeRowMapper(), item.getId()));
        }

        return itemList;
    }

    @Override
    public Item getById(Long id) {
        String sql = SqlQueries.GET_ITEM_BY_ID;

        Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), id);

        item.setAttributes(jdbcTemplate.query(SqlQueries.GET_ATTRIBUTES_BY_ITEM, new AttributeRowMapper(), item.getId()));

        return item;
    }

    @Override
    public void saveOrUpdate(Item item) {
        if (item.getId() == null) {
            String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, null, item.getName(), item.getDescription(), 
                    item.isIsBorrowed(), item.getCategory().getId());
        }
    }

    @Override
    public void delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getBorrowedItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Item> getUnborrowedItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
