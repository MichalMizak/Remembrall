package sk.upjs.paz1c.nezabudal.other;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.Assert.*;

/**
 *
 * @author Mikey
 */
public class ObjectFactoryTest {
    
    @Test
    public void getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = ObjectFactory.INSTANCE.getJdbcTemplate();
        
        assertNotEquals(jdbcTemplate, null);
    }
}
