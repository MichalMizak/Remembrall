package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.forms.RemembrallForm;

public class AttributeNamesTableModel extends AbstractTableModel {

    private List<String> attributeNames = new ArrayList<>();

    private static final int COLUMN_COUNT = 1;

    private static final boolean EDITABILITY = true;

    public AttributeNamesTableModel() {
        attributeNames.add("");
    }

    public List<String> getAttributeNames() {

        for (int i = 0; i < attributeNames.size(); i++) {
            String attribute = attributeNames.get(i);
            if (attribute != null && attribute.trim().equals("")) {
                attributeNames.remove(i);
            }
        }
        return attributeNames;
    }

    public void setAttributeNames(List<String> attributeNames) {
        this.attributeNames = attributeNames;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return attributeNames.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return attributeNames.get(rowIndex);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        String stValue = ((String) value);
        boolean lastRow = row == attributeNames.size() - 1;
        boolean isWhitespace = stValue.trim().equals("");

        if (isWhitespace && !lastRow) {
            attributeNames.remove(attributeNames.get(row));
            fireTableRowsDeleted(row, row);
            return;
        }

        if (lastRow && !isWhitespace) {
            attributeNames.add("");
            fireTableRowsInserted(row + 1, row + 1);
            //fireTableCellUpdated(row + 1, col);
        }

        attributeNames.set(row, stValue);
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return EDITABILITY;
    }
}
