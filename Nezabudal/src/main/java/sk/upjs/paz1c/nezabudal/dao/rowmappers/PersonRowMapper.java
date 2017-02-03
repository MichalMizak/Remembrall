package sk.upjs.paz1c.nezabudal.dao.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import sk.upjs.paz1c.nezabudal.entity.Person;

/**
 *
 * @author Mikey
 */
public class PersonRowMapper implements RowMapper<Person> {

     @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {
        Person person = new Person();
        
        person.setId(rs.getLong("person_id"));
        person.setName(rs.getString("person_name"));
        person.setSurname(rs.getString("person_surname"));
        person.setEmail(rs.getString("person_email"));
        person.setPhoneNumber(rs.getString("person_phone_number"));
        
        return person;
    }
}
