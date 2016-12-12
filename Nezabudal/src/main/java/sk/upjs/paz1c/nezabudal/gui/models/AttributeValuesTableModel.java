package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;

public class AttributeValuesTableModel extends AbstractTableModel {

    private CategoryManager categoryManager = ObjectFactory.INSTANCE.getCategoryManager();

    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();

    private Category category;

    private List<Attribute> attributes = new ArrayList<>();

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    private static final String[] COLUMN_VALUES = {"Vlastnosť", ""};

    private static final int COLUMN_COUNT = COLUMN_VALUES.length;

    public AttributeValuesTableModel(Category category) {
        initialize(category);
    }

    public void initialize(Category category) {
        this.category = category;

        attributes = attributeManager.getByCategory(category);
    }

    public void aktualizovat(Category category) {
        this.category = category;
        attributes = attributeManager.getByCategory(category);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return attributes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return attributes.get(rowIndex).getName();
            case 1:
                return attributes.get(rowIndex).getValue();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        attributes.get(row).setValue((String) value);

        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_VALUES[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 1;
    }
}
