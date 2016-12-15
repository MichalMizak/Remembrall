package sk.upjs.paz1c.nezabudal.other;

import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;

/**
 *
 * @author Mikey
 */
public enum GuiObjectFactory {
    INSTANCE;
    
    private CategoryComboBoxModel categoryComboBoxModel;

    public CategoryComboBoxModel getCategoryComboBoxModel() {
        if (categoryComboBoxModel == null) {
            categoryComboBoxModel = new CategoryComboBoxModel();
        }
        return categoryComboBoxModel;
    }
}
