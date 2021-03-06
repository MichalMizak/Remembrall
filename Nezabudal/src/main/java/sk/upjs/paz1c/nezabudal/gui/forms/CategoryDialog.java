package sk.upjs.paz1c.nezabudal.gui.forms;

import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.gui.models.AttributeNamesTableModel;
import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;
import sk.upjs.paz1c.nezabudal.managers.AttributeManager;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;
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
public class CategoryDialog extends javax.swing.JDialog {

    Category category;

    private CategoryManager categoryManager = ObjectFactory.INSTANCE.getCategoryManager();

    private AttributeManager attributeManager = ObjectFactory.INSTANCE.getAttributeManager();

    /**
     * Creates new form AddCategoryDialog
     */
    public CategoryDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        GuiUtilities.setPositionMiddle(parent, this);
        setTitle("Nová kategória");

        categoryAttributeNameTable.getTableHeader().setUI(null);
        category = new Category();
        saveOrEditCategoryButton.setText("Pridaj");

    }

    public CategoryDialog(java.awt.Frame parent, boolean modal, Category category) {
        super(parent, modal);
        initComponents();
        GuiUtilities.setPositionMiddle(parent, this);
        setTitle("Uprav kategóriu");

        categoryAttributeNameTable.getTableHeader().setUI(null);
        this.category = category;
        categoryTitleTextField.setText(category.getTitle());
        getAttributeTableModel().setAttributes(attributeManager.getByCategory(category));
        saveOrEditCategoryButton.setText("Uprav");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleLabel = new javax.swing.JLabel();
        categoryTitleTextField = new javax.swing.JTextField();
        attributesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryAttributeNameTable = new javax.swing.JTable();
        saveOrEditCategoryButton = new javax.swing.JButton();
        warningTextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        TitleLabel.setText("Názov:");

        categoryTitleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryTitleTextFieldActionPerformed(evt);
            }
        });

        attributesLabel.setText("Vlastnosti:");

        categoryAttributeNameTable.setModel(new sk.upjs.paz1c.nezabudal.gui.models.AttributeNamesTableModel());
        jScrollPane1.setViewportView(categoryAttributeNameTable);

        saveOrEditCategoryButton.setText("Pridaj");
        saveOrEditCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOrEditCategoryButtonActionPerformed(evt);
            }
        });

        warningTextLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        warningTextLabel.setText("Potvrďte vlastnosť stlačením \"enter\"");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(TitleLabel)
                                .addGap(18, 18, 18)
                                .addComponent(categoryTitleTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(attributesLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveOrEditCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 184, Short.MAX_VALUE)
                        .addComponent(warningTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(categoryTitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attributesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningTextLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveOrEditCategoryButton)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoryTitleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryTitleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryTitleTextFieldActionPerformed

    private void saveOrEditCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOrEditCategoryButtonActionPerformed

        // VALIDATE
        String title = categoryTitleTextField.getText();
        String validation = Validator.validateCategory(category, title);

        if (validation == null) {

            category.setTitle(title);

            List<Attribute> attributes = getAttributeTableModel().getAttributes();

            categoryManager.saveOrEdit(category, attributes);

            setVisible(false);
            dispose();

        } else {
            WarningDialog warningDialog = new WarningDialog(this, true, validation);
            warningDialog.setVisible(true);
        }
    }//GEN-LAST:event_saveOrEditCategoryButtonActionPerformed

    private AttributeNamesTableModel getAttributeTableModel() {
        return (AttributeNamesTableModel) categoryAttributeNameTable.getModel();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel attributesLabel;
    private javax.swing.JTable categoryAttributeNameTable;
    private javax.swing.JTextField categoryTitleTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveOrEditCategoryButton;
    private javax.swing.JLabel warningTextLabel;
    // End of variables declaration//GEN-END:variables
}
