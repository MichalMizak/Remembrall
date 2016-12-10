package sk.upjs.paz1c.nezabudal.forms;

import java.time.LocalDateTime;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;
import sk.upjs.paz1c.nezabudal.gui.models.ItemComboBoxModel;
import sk.upjs.paz1c.nezabudal.gui.models.LoanTableModel;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;
import sk.upjs.paz1c.nezabudal.other.Validator;

/**
 *
 * @author Mikey
 */
public class AddLoanDialog extends javax.swing.JDialog {

    private static final int IS_BORROWED_ROW = 2;

    private final LoanManager loanManager = ObjectFactory.INSTANCE.getLoanManager();

    Loan loan;

    /**
     * Creates new form AddItemDialog
     */
    public AddLoanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public AddLoanDialog(java.awt.Frame parent, boolean modal, Loan loan) {
        super(parent, modal);
        initComponents();
        getItemComboBoxModel().setSelectedItem(loan.getItem());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loanTable = new javax.swing.JTable();
        categoryComboBox = new javax.swing.JComboBox<>();
        addLoanButton1 = new javax.swing.JButton();
        itemLabel = new javax.swing.JLabel();
        itemComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nová pôžička");
        setModal(true);

        categoryLabel.setText("Kategória");

        loanTable.setModel(new LoanTableModel());
        jScrollPane1.setViewportView(loanTable);

        categoryComboBox.setModel(ObjectFactory.INSTANCE.getCategoryComboBoxModel());
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        addLoanButton1.setText("Požičaj");
        addLoanButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLoanButton1ActionPerformed(evt);
            }
        });

        itemLabel.setText("Predmet");

        itemComboBox.setModel(new ItemComboBoxModel(getSelectedCategory()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addLoanButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemComboBox, 0, 207, Short.MAX_VALUE))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemLabel)
                    .addComponent(itemComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addLoanButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        getItemComboBoxModel().refresh(getSelectedCategory());
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private ItemComboBoxModel getItemComboBoxModel() {
        return (ItemComboBoxModel) itemComboBox.getModel();
    }

    private void addLoanButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLoanButton1ActionPerformed

        // TODO TESTING
        String[] secondRowValues = ((LoanTableModel) loanTable.getModel()).getSecondColumnValues();

        // potentially will be made into a checkbox
        String isBorrowedString = secondRowValues[IS_BORROWED_ROW - 1];
        boolean isBorrowed;
        Item item = getSelectedItem();
        String description = secondRowValues[0];
        String person = secondRowValues[2];

        String validation = Validator.validateLoanBorrowedToMe(isBorrowedString);
        // EW EW EW EW SORRY FOR THIS
        if (validation.length() < 6) {
            isBorrowed = "true".equals(isBorrowedString);
        } else {
            createWarningDialog(validation);
            return;
        }

        validation = Validator.validateLoan(item, description, person);
        if (validation != null) {
            createWarningDialog(validation);
            return;
        }

        LocalDateTime since;
        Object validation2 = Validator.validateLoanSince(secondRowValues[3]);
        try {
            validation = (String) validation2;
            createWarningDialog(validation);
            return;
        } catch (ClassCastException exception) {
            since = (LocalDateTime) validation2;
        }

        LocalDateTime until;
        validation2 = Validator.validateLoanUntil(secondRowValues[4]);
        try {
            validation = (String) validation2;
            createWarningDialog(validation);
            return;
        } catch (ClassCastException exception) {
            until = (LocalDateTime) validation2;
        }
        // only after validation
        Loan loan = new Loan(item, description, isBorrowed, person, since, until);
        loanManager.saveOrEdit(loan);

        setVisible(false);
        dispose();
    }//GEN-LAST:event_addLoanButton1ActionPerformed

    private void createWarningDialog(String validation) {
        WarningDialog warningDialog = new WarningDialog(this, true, validation);
        warningDialog.setVisible(true);
    }

    private Item getSelectedItem() {
        // validate
        return (Item) getItemComboBoxModel().getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLoanButton1;
    private javax.swing.JComboBox<Category> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JComboBox<Item> itemComboBox;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable loanTable;
    // End of variables declaration//GEN-END:variables

    private Category getSelectedCategory() {
        return (Category) ((CategoryComboBoxModel) categoryComboBox.getModel()).getSelectedItem();
    }
}
