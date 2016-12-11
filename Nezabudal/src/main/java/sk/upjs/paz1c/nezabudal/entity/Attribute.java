package sk.upjs.paz1c.nezabudal.entity;

public class Attribute {

    private Long id;

    private String name;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Attribute () {
        
    }

    @Override
    public String toString() {
        return "Attribute{" + "name=" + name + ", value=" + value + '}';
    }

}
