package sk.upjs.paz1c.nezabudal.forms;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.gui.models.AttributeValuesTableModel;
import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;
import sk.upjs.paz1c.nezabudal.other.Validator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mikey
 */
public class ItemDialog extends javax.swing.JDialog {

    public static final boolean MODALITY = true;
    private static final boolean IS_BORROWED_DEFAULT = false;

    private ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    private Item item;

    /**
     * Creates new form AddLoanDialog
     */
    public ItemDialog(java.awt.Frame parent, boolean modal) {
        super(parent, MODALITY);

        initComponents();

        item = new Item();
        // attributesTable.setModel();

        //  AttributeValuesTableModel tableModel = (AttributeValuesTableModel) attributesTable.getModel();
        //  tableModel.initialize(category);
    }

    public ItemDialog(java.awt.Frame parent, boolean modal, Item item) {
        //Item item = new Item(nameTextField.getText(), specificationTextArea.getText(), stateTextArea.getText(),
        //       IS_BORROWED_DEFAULT, getSelectedCategory(), list);
        super(parent, MODALITY);
        initComponents();

        this.item = item;

        nameTextField.setText(item.getName());
        specificationTextArea.setText(item.getDescription());

        // only looks horrific
        getAttributeValuesTableModel().setAttributes(item.getAttributes());

        addItemButton.setText("Uprav predmet");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addLoanButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attributesTable = new javax.swing.JTable();
        addItemButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        specificationLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        specificationTextArea = new javax.swing.JTextArea();
        nameTextField = new javax.swing.JTextField();

        addLoanButton.setText("Pridaj");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nová pôžička");
        setModal(true);

        categoryComboBox.setModel(new CategoryComboBoxModel());
        categoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Kategória");

        attributesTable.setModel(new AttributeValuesTableModel(getSelectedCategory()));
        attributesTable.setToolTipText("");
        attributesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(attributesTable);

        addItemButton.setText("Vytvor predmet");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Názov");

        specificationLabel.setText("Popis");

        specificationTextArea.setColumns(20);
        specificationTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        specificationTextArea.setLineWrap(true);
        specificationTextArea.setRows(4);
        jScrollPane2.setViewportView(specificationTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(specificationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addItemButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specificationLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addItemButton)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryComboBoxActionPerformed
        AttributeValuesTableModel model = getAttributeValuesTableModel();
        model.aktualizovat(getSelectedCategory());

        // attributesTable.setModel(new AttributeValuesTableModel(getSelectedCategory()));
    }//GEN-LAST:event_categoryComboBoxActionPerformed

    private AttributeValuesTableModel getAttributeValuesTableModel() {
        return (AttributeValuesTableModel) attributesTable.getModel();
    }

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
        // add item
        // TODO proper validation
        List<Attribute> list = (getAttributeValuesTableModel()).getAttributes();

        String name = nameTextField.getText();
        String description = specificationTextArea.getText();
        // boolean isBorrowed = item.isIsBorrowed();
        Category selectedCategory = getSelectedCategory();

        String validation = Validator.validateItem(name, description, selectedCategory, list);
        if (validation == null) {
            item.setName(name);
            item.setDescription(description);
            //  item.setIsBorrowed(isBorrowed);
            item.setCategory(selectedCategory);
            item.setAttributes(list);

            itemManager.saveOrUpdate(item);

            setVisible(false);
            dispose();
        } else {
            WarningDialog warningDialog = new WarningDialog(this, true, validation);
            warningDialog.setVisible(true);
        }
    }//GEN-LAST:event_addItemButtonActionPerformed

    private Category getSelectedCategory() {
        return (Category) ((CategoryComboBoxModel) categoryComboBox.getModel()).getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton addLoanButton;
    private javax.swing.JTable attributesTable;
    private javax.swing.JComboBox<Category> categoryComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel specificationLabel;
    private javax.swing.JTextArea specificationTextArea;
    // End of variables declaration//GEN-END:variables
}
