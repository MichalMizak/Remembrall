package old;


import old.Attribute;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AttributesTableModel extends AbstractTableModel {

    private AttributesDao attributeDao = new AttributesDao();

    private static final String[] NAZVY_STLPCOV = {"Vlastnosť", ""};

    private static final int POCET_STLPCOV = NAZVY_STLPCOV.length;

    @Override
    public int getRowCount() {
        return attributeDao.getAttributes().size();
    }

    @Override
    public int getColumnCount() {
        return POCET_STLPCOV;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Attribute attribute = attributeDao.getAttributes().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return attribute.getName();
            case 1:
                return attribute.getValue();
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
        Attribute attribute = attributeDao.getAttributes().get(row);
        switch (col) {
            case 1: attribute.setValue((String) value);
        }
        
        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return NAZVY_STLPCOV[columnIndex];
    }

    void aktualizovat() {
        fireTableDataChanged();
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
