package sk.upjs.paz1c.nezabudal.other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
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

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

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

    public static String validateItem(String name, String description, Category selectedCategory, List<String> list) {

        if (name == null || name.trim().equals("")) {
            return "Zadajte názov";
        }

        if (description == null || description.trim().equals("")) {
            return "Zadajte popis";
        }
        return null;
    }

    // "Popis", "Požičané mne", "Osoba", "Od", "Do"
    public static String validateLoan(Item item, String description, String person) {
        if (item.isIsBorrowed()) {
            return "Predmet nesmie byť zapožičaný";
        }
        if (person == null || person.trim().equals("")) {
            return "Vyplňte riadok Osoba";
        }

        return null;
    }

    public static Object validateLoanSince(String since) {
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(since, formatter);
        } catch (DateTimeParseException exception) {
            return "Nesprávny formát riadku \"Od\"";
        }
        return dateTime;
    }

    public static Object validateLoanUntil(String until) {
        LocalDateTime dateTime;
        try {
            dateTime = LocalDateTime.parse(until, formatter);
        } catch (DateTimeParseException exception) {
            return "Nesprávny formát riadku \"Od\"";
        }
        return dateTime;
    }

    public static String validateLoanBorrowedToMe(String borrowedToMe) {
        if (!(borrowedToMe == null) && (borrowedToMe.toLowerCase().equals("ano") || borrowedToMe.toLowerCase().equals("áno"))) {
            return "true";
        } else if (!(borrowedToMe == null) && borrowedToMe.toLowerCase().equals("nie")) {
            return "false";
        } else {
            return "Nesprávny formát riadku \"Požičané mne\"";
        }
    }
}
