package sk.upjs.paz1c.nezabudal.gui.models;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mikey
 */
public class LoanTableModel extends AbstractTableModel{

    private static final String[] COLUMN_TITLES = {"Vlastnosť", ""};

    private static final int COLUMN_COUNT = COLUMN_TITLES.length;

    private static final String[] FIRST_COLUMN_VALUES = {"Popis", "Požičané mne", "Osoba", "Od", "Do"};
    
    private static final int ROW_COUNT = FIRST_COLUMN_VALUES.length;
    
    private String[] secondColumnValues = new String[ROW_COUNT];

    public String[] getSecondColumnValues() {
        return secondColumnValues;
    }
 
    @Override
    public int getRowCount() {
        return ROW_COUNT;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return FIRST_COLUMN_VALUES[rowIndex];
            case 1:
                return secondColumnValues[rowIndex];
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

        secondColumnValues[row] = (String) value;

        fireTableCellUpdated(row, col);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMN_TITLES[columnIndex];
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
