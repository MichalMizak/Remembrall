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
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.ItemRowMapper;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.other.SqlQueries;

/**
 *
 * @author Mikey
 */
public class MysqlItemDao implements ItemDao {

    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();

    private JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    @Override
    public List<Item> getItems() {
        List<Item> itemList = jdbcTemplate.query(SqlQueries.GET_ALL_ITEMS, new ItemRowMapper());

        setAttributes(itemList);

        return itemList;
    }


    @Override
    public List<Item> getByCategory(Category category) {
        if (category == null)
            return null;
        List<Item> itemList = jdbcTemplate.query(SqlQueries.GET_ITEMS_BY_CATEGORY, new ItemRowMapper(), category.getId());

        setAttributes(itemList);

        return itemList;
    }

    @Override
    public Item getById(Long id) {
        String sql = SqlQueries.GET_ITEM_BY_ID;

        Item item = jdbcTemplate.queryForObject(sql, new ItemRowMapper(), id);
        setAttributes(item);

        return item;
    }

    @Override
    public void saveOrEdit(Item item) {
        if (item.getId() == null) {
            String sql = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";
            // need to get the generated value
            final PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                    final PreparedStatement ps = connection.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, null);
                    ps.setString(2, item.getName());
                    ps.setString(3, item.getDescription());
                    ps.setBoolean(4, item.isIsBorrowed());
                    ps.setLong(5, item.getCategory().getId());
                    return ps;
                }
            };
            final KeyHolder holder = new GeneratedKeyHolder();

            jdbcTemplate.update(psc, holder);
            //jdbcTemplate.update(sql, null, item.getName(), item.getDescription(),
            //         item.isIsBorrowed(), item.getCategory().getId());
            item.setId(holder.getKey().longValue());
            attributeManager.saveOrEditValue(item.getAttributes(), item);
        } else {
            String sql = "UPDATE item SET name = ?, description = ?, is_borrowed = ? where id = ?";
            jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.isIsBorrowed(), item.getId());
            attributeManager.saveOrEditValue(item.getAttributes(), item);
        }
    }

    @Override
    public void delete(Item item) {
        if (item == null) 
            return;
        String sql = "DELETE FROM item WHERE id = ?";
        jdbcTemplate.update(sql, item.getId());
    }

    @Override
    public List<Item> getItems(boolean isBorrowed) {
        List<Item> items = jdbcTemplate.query(SqlQueries.GET_BORROWED_ITEMS,new ItemRowMapper(), isBorrowed);
        setAttributes(items);
        return items;
    }

    private void setAttributes(List<Item> itemList) {
        for (Item item : itemList) {
            setAttributes(item);
        }
    }

    private void setAttributes(Item item) {
        item.setAttributes(attributeManager.getByItem(item));
    }
}
