package sk.upjs.paz1c.nezabudal.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mikey
 */
public class Category {
    
    private Long id; 
    
    private String title;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
      @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
}
