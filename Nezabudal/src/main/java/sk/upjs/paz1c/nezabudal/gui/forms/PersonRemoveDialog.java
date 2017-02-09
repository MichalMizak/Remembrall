package sk.upjs.paz1c.nezabudal.gui.forms;

import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.gui.models.PersonComboBoxModel;
import sk.upjs.paz1c.nezabudal.managers.PersonManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.other.Validator;

/**
 *
 * @author Mikey
 */
public class PersonRemoveDialog extends javax.swing.JDialog {

    private PersonManager personManager = ObjectFactory.INSTANCE.getPersonManager();

    /**
     * Creates new form PersonRemoveDialog
     */
    public PersonRemoveDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        personComboBox = new javax.swing.JComboBox<>();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        personComboBox.setModel(new PersonComboBoxModel());
        personComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personComboBoxActionPerformed(evt);
            }
        });
        personComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                personComboBoxPropertyChange(evt);
            }
        });

        removeButton.setText("Odstráň osobu");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeButton)
                    .addComponent(personComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void personComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personComboBoxActionPerformed

    }//GEN-LAST:event_personComboBoxActionPerformed

    private void personComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_personComboBoxPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_personComboBoxPropertyChange

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        Person person = (Person) personComboBox.getSelectedItem();
        String validation = Validator.personHasNoItems(person);

        if (validation != null) {
            WarningDialog warningDialog = new WarningDialog(this, true, validation);
            warningDialog.setVisible(true);
        } else {
            personComboBox.removeItem(person);
            personManager.delete(person);

            ((PersonComboBoxModel) personComboBox.getModel()).refresh();

            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Person> personComboBox;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}