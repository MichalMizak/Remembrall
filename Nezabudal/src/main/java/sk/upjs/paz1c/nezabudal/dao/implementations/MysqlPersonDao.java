package sk.upjs.paz1c.nezabudal.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import sk.upjs.paz1c.nezabudal.dao.rowmappers.PersonRowMapper;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sk.upjs.paz1c.nezabudal.dao.PersonDao;
import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class MysqlPersonDao implements PersonDao {

    JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();

    @Override
    public List<Person> getPersons() {
        String sql = "SELECT \n"
                + "		id as person_id,\n"
                + "		name as person_name,\n"
                + "		surname as person_surname,\n"
                + "		email as person_email,\n"
                + "		phone_number as person_phone_number\n"
                + "	FROM person;";

        List<Person> persons = jdbcTemplate.query(sql, new PersonRowMapper());
        return persons;

    }

    @Override
    public Person getById(Long id) {

        String sql = "SELECT \n"
                + "		id as person_id,\n"
                + "		name as person_name,\n"
                + "		surname as person_surname,\n"
                + "		email as person_email,\n"
                + "		phone_number as person_phone_number\n"
                + "	FROM person WHERE id = ?;";

        List<Person> persons = jdbcTemplate.query(sql, new PersonRowMapper(), id);

        if (persons.isEmpty()) {
            return null;
        }
        Person person = persons.get(0);

        return person;
    }

    @Override
    public void saveOrEdit(Person person) {
        if (person.getId() == null) {
            String sql = "INSERT INTO person VALUES (?, ?, ?, ?, ?)";

            // need to get the generated value
            final PreparedStatementCreator psc = new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
                    final PreparedStatement ps = connection.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, null);
                    ps.setString(2, person.getName());
                    ps.setString(3, person.getSurname());
                    ps.setString(4, person.getEmail());
                    ps.setString(5, person.getPhoneNumber());
                    return ps;
                }
            };
            final KeyHolder holder = new GeneratedKeyHolder();

            jdbcTemplate.update(psc, holder);

            Number number = holder.getKey();
            person.setId(number.longValue());
            
        } else {
            String sql = "UPDATE person SET name = ?, surname = ?, email = ?, phone_number = ? WHERE id = ?";
            jdbcTemplate.update(sql, person.getName(), person.getSurname(), person.getEmail(), person.getPhoneNumber(), person.getId());
        }
    }

    @Override
    public void delete(Person person) {
        if (person == null) {
            return;
        }
        String sql = "DELETE from person where id = ?";
        jdbcTemplate.update(sql, person.getId());
    }
}
