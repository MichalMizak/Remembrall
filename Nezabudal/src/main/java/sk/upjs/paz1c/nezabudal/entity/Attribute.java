package sk.upjs.paz1c.nezabudal.entity;

public class Attribute {

    private Long nameId;
    private Long valueId;

    private String name;
    private String value;

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Attribute() {

    }

    @Override
    public String toString() {
        return name;
    }
}
