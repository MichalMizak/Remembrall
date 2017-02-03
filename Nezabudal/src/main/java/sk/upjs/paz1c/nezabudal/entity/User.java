package sk.upjs.paz1c.nezabudal.entity;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCrypt;

/**
 *
 * @author Mikey
 */
public class User extends Person {

    private String salt;
    private String passwordHash;

    private List<Person> createdPersons;

    public List<Person> getCreatedPersons() {
        return createdPersons;
    }

    public void setCreatedPersons(List<Person> createdPersons) {
        this.createdPersons = createdPersons;
    }

    public void setPassword(String password) {
        if (salt == null) {
            salt = BCrypt.gensalt();
        }
        this.passwordHash = BCrypt.hashpw(password, salt);
    }

    public boolean checkPassword(String password) {
        String result = BCrypt.hashpw(password, salt);
        return result.equals(passwordHash);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
