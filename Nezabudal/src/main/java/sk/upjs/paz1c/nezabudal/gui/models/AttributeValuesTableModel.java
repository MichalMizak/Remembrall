package sk.upjs.paz1c.nezabudal.gui.models;

import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import old.Attribute;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;

public class AttributeValuesTableModel extends AbstractTableModel {

    private CategoryDao categoryDao = ObjectFactory.INSTANCE.getCategoryDao();

    private Category category;

    private String[] attributeValues;

    private static final String[] NAZVY_STLPCOV = {"Vlastnosť", ""};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    public AttributeValuesTableModel(Category category) {
        initialize(category);
    }

    public void initialize(Category category) {
        this.category = category;

        List<String> attr = category.getAttributes();
        int size = attr.size();
        attributeValues = new String[size];
    }

    public void aktualizovat(Category category) {
        //  if (!this.category.equals(category)) {
        this.category = category;
        attributeValues = new String[category.getAttributes().size()];
        fireTableStructureChanged();
        fireTableDataChanged();
        // }
    }

    @Override
    public int getRowCount() {
        return category.getAttributes().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return category.getAttributes().get(rowIndex);
            case 1:
                return attributeValues[rowIndex];
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Boolean.class;
        }

        return super.getColumnClass(columnIndex);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {

        attributeValues[row] = (String) value;

        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        switch (column) {
            case 1:
                return true;
            default:
                return false;
        }
    }

}
