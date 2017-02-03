package sk.upjs.paz1c.nezabudal.other;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;

/**
 *
 * @author Mikey
 */
public class Validator {

    private static final ItemManager ITEM_MANAGER = ObjectFactory.INSTANCE.getItemManager();

    private static final CategoryManager CATEGORY_MANAGER = ObjectFactory.INSTANCE.getCategoryManager();

    private static final LoanManager LOAN_MANAGER = ObjectFactory.INSTANCE.getLoanManager();

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static final String WRONG_BORROWED_TO_ME_FORMAT = "Nesprávny formát riadku \"Požičané mne\"";

    public static String validateCategory(Category category, String title) {

        boolean titleIsEmpty = title == null || title.trim().equals("");

        if (titleIsEmpty) {
            return "Zadaj názov!";
        }
        boolean hasNoItem = ITEM_MANAGER.getByCategory(category).isEmpty();

        if (!hasNoItem) {
            return "Kategória musí byť prázdna!";
        }
        return null;
    }

    public static String validateCategoryCount() {
        List<Category> categories = CATEGORY_MANAGER.getCategories();
        if (categories.size() == 1) {
            return "Musí existovať aspoň jedna kategória!";
        } else {
            return null;
        }
    }

    public static String validateItemCount() {
        if (ITEM_MANAGER.getItems().isEmpty()) {
            return "Zoznam predmetov je prázdny!";
        }
        return null;
    }

    public static String validateLoanCount() {
        if (LOAN_MANAGER.getLoans().isEmpty()) {
            return "Zoznam pôžičiek je prázdny!";
        }
        return null;
    }

   public static String categoryHasNoItems(Category category) {
        List<Item> items = ITEM_MANAGER.getByCategory(category);
        if (items != null) {
            boolean hasNoItem = items.isEmpty();
            if (hasNoItem) {
                return null;
            }

        } else {
            return "Kategória musí byť prázdna!";
        }
        return null;
    }

    public static String validateItem(String name) {

        if (name == null || name.trim().equals("")) {
            return "Zadajte názov";
        }
//
//        if (description == null || description.trim().equals("")) {
//            return "Zadajte popis";
//        }
        return null;
    }

    // "Popis", "Požičané mne", "Osoba", "Od", "Do"
    public static String validateLoan(Item item, boolean editMode) {
        if (item.isIsBorrowed() && !editMode) {
            return "Predmet nesmie byť zapožičaný";
        }
        // if (person == null || person.trim().equals("")) {
           // return "Vyplňte riadok Osoba";
        //}

        return null;
    }

    public static Object validateLoanSince(String since) {
        System.out.println(since);
        if (since == null || since.trim().equals("")) {
            return null;
        }
        LocalDateTime dateTime;
        LocalDateTime date = LocalDateTime.now();
        String example = date.format(FORMATTER);

        try {
            dateTime = LocalDateTime.parse(since, FORMATTER);
        } catch (DateTimeParseException exception) {
            return "Nesprávny formát riadku \"Od\"";
        }
        return dateTime;
    }

    public static Object validateLoanUntil(String until) {
        if (until == null || until.trim().equals("")) {
            return null;
        }
        LocalDateTime dateTime;
        LocalDateTime date = LocalDateTime.now();
        String example = date.format(FORMATTER);

        try {
            dateTime = LocalDateTime.parse(until, FORMATTER);
        } catch (DateTimeParseException exception) {
            return "Nesprávny formát riadku \"Do\"";
        }
        return dateTime;
    }

    public static Boolean validateLoanBorrowedToMe(String borrowedToMe) {
        if (!(borrowedToMe == null) && (borrowedToMe.toLowerCase().equals("ano") || borrowedToMe.toLowerCase().equals("áno"))) {
            return true;
        } else if (!(borrowedToMe == null) && borrowedToMe.toLowerCase().equals("nie")) {
            return false;
        }
        return null;
    }
}
