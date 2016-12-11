package sk.upjs.paz1c.nezabudal.entity;

import java.util.List;

/**
 *
 * @author Mikey
 */
public class Item {
    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String name;

    private String description;

    private boolean isBorrowed;
    
    private Category category;
    
    // the values of the category attributes
    private List<Attribute> attributes;

    public Item(String itemName, String itemDescription, boolean isBorrowed, Category category, List<Attribute> attributeValues) {
        this.name = itemName;
        this.description = itemDescription;
        this.isBorrowed = isBorrowed;
        this.category = category;
        this.attributes = attributeValues;
    }

    public Item() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return name;
    }

    
    
}
