package sk.upjs.paz1c.nezabudal.gui.models;

import java.util.List;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.nezabudal.entity.Person;
import sk.upjs.paz1c.nezabudal.managers.PersonManager;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;

/**
 *
 * @author Mikey
 */
public class PersonComboBoxModel extends DefaultComboBoxModel<Person> {

    private PersonManager personManager = ObjectFactory.INSTANCE.getPersonManager();

    public PersonComboBoxModel() {
        refresh();
    }

    public void refresh() {
        removeAllElements();

        List<Person> persons = personManager.getPersons();

        for (Person person : persons) {
            addElement(person);
        }
    }
}
