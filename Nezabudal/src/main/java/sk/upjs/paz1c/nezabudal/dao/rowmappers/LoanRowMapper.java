package sk.upjs.paz1c.nezabudal.dao.rowmappers;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;

/**
 *
 * @author Mikey
 */
public class LoanRowMapper implements RowMapper<Loan> {

    /**
     * This method won't set the item, need to do it separately in DAO
     *
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loan loan = new Loan();

        loan.setId(rs.getLong("loan_id"));
        loan.setSpecification(rs.getString("loan_specification"));
        loan.setLentToMe(rs.getBoolean("loan_lent_to_me"));
        loan.setPerson(rs.getString("loan_person"));

        Item item = new Item();
        item.setId(rs.getLong("loan_item_id"));
        loan.setItem(item);

        Timestamp timestamp = rs.getTimestamp("loan_since");
        if (timestamp == null) {
            loan.setStartDate(null);
        } else {
            loan.setStartDate(timestamp.toLocalDateTime());
        }

        timestamp = rs.getTimestamp("loan_until");
        if (timestamp == null) {
            loan.setReturnDate(null);
        } else {
            loan.setReturnDate(timestamp.toLocalDateTime());
        }

        return loan;
    }

}
