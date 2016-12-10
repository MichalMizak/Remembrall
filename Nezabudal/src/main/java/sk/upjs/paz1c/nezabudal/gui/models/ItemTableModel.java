package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class ItemTableModel extends AbstractTableModel {

    private final ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    private List<Item> itemList;

    private Category category;

    private final String[] columnTitles = {"Názov", "Popis"};

    private String[] attributeNameColumnTitles;

    private int columnCount;

    private int rowCount;

    private static final boolean EDITABILITY = false;

    public ItemTableModel(Category category) {
        refresh(category);
    }

    public void refresh(Category category) {
        this.category = category;

        fireTableDataChanged();
        setAttributeNameColumnTitles(category.getAttributes().toArray(new String[0]));

        itemList = itemManager.getByCategory(category);
        setColumnCount();
        setRowCount();

        fireTableStructureChanged();
        fireTableDataChanged();
    }

    private void setColumnCount() {
        columnCount = attributeNameColumnTitles.length + columnTitles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = itemList.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getName();
            case 1:
                return item.getDescription();
        }
        return item.getAttributeValues().get(columnIndex - columnTitles.length);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return EDITABILITY;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    private void setRowCount() {
        rowCount = itemList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex < columnTitles.length) {
            return columnTitles[columnIndex];
        } else {
            return attributeNameColumnTitles[columnIndex - columnTitles.length];
        }
    }

    public String[] getAttributeNameColumnTitles() {
        return attributeNameColumnTitles;
    }

    private void setAttributeNameColumnTitles(String[] attributeNameColumnTitles) {
        this.attributeNameColumnTitles = attributeNameColumnTitles;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    public Item getItemAt(int index) {
        return itemList.get(index);
    }
}
