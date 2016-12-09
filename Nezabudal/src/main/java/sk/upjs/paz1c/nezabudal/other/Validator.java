package sk.upjs.paz1c.nezabudal.other;

import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class Validator {

    private static final ItemManager itemManager = ObjectFactory.INSTANCE.getItemManager();

    public static boolean validate(Item item) {
        return false;
    }

    public static String validateCategory(Category category, String title) {

        boolean titleIsEmpty = title == null || title.trim().equals("");

        if (titleIsEmpty) {
            return "Zadaj názov!";
        }
        boolean hasNoItem = itemManager.getByCategory(category).isEmpty();

        if (!hasNoItem) {
            return "Kategória musí byť prázdna!";
        }

        return null;
    }

    public static String categoryHasNoItems(Category category) {
        boolean hasNoItem = itemManager.getByCategory(category).isEmpty();
        if (hasNoItem) {
            return null;
        } else {
            return "Kategória musí byť prázdna!";
        }
    }

}
