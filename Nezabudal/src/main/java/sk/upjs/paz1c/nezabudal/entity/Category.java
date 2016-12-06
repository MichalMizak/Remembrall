package sk.upjs.paz1c.nezabudal.entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mikey
 */
public class Category {
    
    private Long id; 
    
    private String title;
    
    /* a list of names of attributes the items 
     in this category will be able to have */
    private List<String> attributes;

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
   
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
