package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.gui.forms.RemembrallForm;

public class AttributeNamesTableModel extends AbstractTableModel {

    private List<Attribute> attributes = new ArrayList<>();

    private static final int COLUMN_COUNT = 1;

    private static final boolean EDITABILITY = true;

    public AttributeNamesTableModel() {
        attributes.add(new Attribute("", ""));
    }

    public List<Attribute> getAttributes() {

        for (int i = 0; i < attributes.size(); i++) {
            String attribute = attributes.get(i).getName();
            if (attribute != null && attribute.trim().equals("")) {
                attributes.remove(i);
            }
        }
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
//        List<String> temp = new ArrayList<>();
//        
//        for(Attribute attribute : attributeNames) {
//            
//        }

        this.attributes = attributes;

        if (attributes == null) {
            attributes = new ArrayList<>();
        }
        attributes.add(new Attribute("", ""));

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
        return attributes.get(rowIndex);
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        String stValue = ((String) value);
        boolean lastRow = row == attributes.size() - 1;
        boolean isWhitespace = stValue.trim().equals("");

        if (isWhitespace && !lastRow) {
            attributes.remove(attributes.get(row));
            fireTableRowsDeleted(row, row);
            return;
        }

        if (lastRow && !isWhitespace) {
            attributes.add(new Attribute("", ""));
            fireTableRowsInserted(row + 1, row + 1);
            //fireTableCellUpdated(row + 1, col);
        }

        attributes.get(row).setName(stValue);
        fireTableCellUpdated(row, col);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return EDITABILITY;
    }
}
