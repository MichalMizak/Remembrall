package sk.upjs.paz1c.nezabudal.entity;

import java.util.List;

/**
 *
 * @author Mikey
 */
public class Item {
    
    private Long id;

    private String itemName;

    private String itemDescription;

    private String itemState;

    private boolean isBorrowed;
    
    private Category category;
    
    // the values of the category attributes
    private List<String> attributeValues;

    public Item(String itemName, String itemDescription, String itemState, boolean isBorrowed, Category category, List<String> attributeValues) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemState = itemState;
        this.isBorrowed = isBorrowed;
        this.category = category;
        this.attributeValues = attributeValues;
    }

    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemState() {
        return itemState;
    }

    public void setItemState(String itemState) {
        this.itemState = itemState;
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

    public List<String> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(List<String> attributeValues) {
        this.attributeValues = attributeValues;
    }

   

    @Override
    public String toString() {
        return itemName;
    }

    
    
}
