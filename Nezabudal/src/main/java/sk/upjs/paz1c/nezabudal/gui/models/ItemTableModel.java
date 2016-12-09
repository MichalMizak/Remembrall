package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class ItemTableModel extends AbstractTableModel {

    private final ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();
    
    private List<Item> itemList;
    
    private Category category;

    private String[] columnTitles;

    private int columnCount;

    private int rowCount;
    
    private static final boolean EDITABILITY = false;
    
    public ItemTableModel(Category category) {
        refresh(category);
    }

    public void refresh(Category category) {
        this.category = category;
        setColumnTitles(category.getAttributes().toArray(new String[0]));
        itemList = itemManager.getByCategory(category);
        columnCount = columnTitles.length;    
        setRowCount() ;
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Item item = itemList.get(rowIndex);
       return item.getAttributeValues().get(columnIndex);
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
        return columnTitles[columnIndex];
    }

    public String[] getColumnTitles() {
        return columnTitles;
    }

    private void setColumnTitles(String[] columnTitles) {
        this.columnTitles = columnTitles;
    }

    private void setCategory(Category category) {
        this.category = category;
    }    
}
