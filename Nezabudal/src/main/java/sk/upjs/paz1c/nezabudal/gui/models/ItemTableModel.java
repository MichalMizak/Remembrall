package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class ItemTableModel extends AbstractTableModel {

    private final ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();

    private List<Item> itemList = new ArrayList<>();

    private Category category;

    private final String[] columnTitles = {"Názov", "Popis"};

    private List<Attribute> attributeNameColumnTitles;

    private int columnCount;

    private int rowCount;

    private static final boolean EDITABILITY = false;

    public ItemTableModel(Category category) {
        refresh(category);
    }

    public void refresh(Category category) {
        this.category = category;

        fireTableDataChanged();
        setAttributeNameColumnTitles(attributeManager.getByCategory(category));

        itemList = itemManager.getByCategory(category);
        setColumnCount();
        setRowCount();

        fireTableStructureChanged();
        fireTableDataChanged();
    }

    private void setColumnCount() {
        columnCount = attributeNameColumnTitles.size() + columnTitles.length;
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
        Attribute attributeAtColumn = attributeManager.getByNameId(attributeNameColumnTitles.get(columnIndex - columnTitles.length).getNameId(), item);
        return attributeAtColumn.getValue();
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
            return attributeNameColumnTitles.get(columnIndex - columnTitles.length).getName();
        }
    }

    public List<Attribute> getAttributeNameColumnTitles() {
        return attributeNameColumnTitles;
    }

    private void setAttributeNameColumnTitles(List<Attribute> attributeNameColumnTitles) {
        this.attributeNameColumnTitles = attributeNameColumnTitles;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    public Item getItemAt(int index) {
        return itemList.get(index);
    }
}
