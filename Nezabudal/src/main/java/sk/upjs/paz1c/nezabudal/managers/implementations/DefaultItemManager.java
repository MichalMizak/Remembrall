package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.entity.Loan;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;

/**
 *
 * @author Mikey
 */
public class DefaultItemManager implements ItemManager {

    private ItemDao itemDao = ObjectFactory.INSTANCE.getItemDao();
    //  private LoanDao loanDao = ObjectFactory.INSTANCE.getLoanDao();

    // DAO methods
    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public void saveOrEdit(Item item) {
        itemDao.saveOrEdit(item);
    }

    @Override
    public List<Item> getByCategory(Category category) {
        return itemDao.getByCategory(category);
    }

    @Override
    public void delete(Item item) {
        itemDao.delete(item);
    }

    @Override
    public Item getById(Long id) {
        return itemDao.getById(id);
    }

    @Override
    public List<Item> getNotBorrowedItems() {
        return itemDao.getItems(false);
    }

    @Override
    public List<Item> getBorrowedItems() {
        return itemDao.getItems(true);
    }

    // other filters
    @Override
    public List<Item> getByCategory(boolean lentByMeCheckBox, boolean lentToMeCheckBox,
            boolean notLentCheckBox, Category category) {
        System.out.println(lentByMeCheckBox + "=lentbyme, " + lentToMeCheckBox
                + "=lenttome, " + notLentCheckBox + "=notlent @DefaultItemManager");
        List<Item> items = new ArrayList<>();
        List<Item> notLentItems;

        if (notLentCheckBox) {
            notLentItems = itemDao.getItems(false);
        } else {
            notLentItems = new ArrayList<>();
        }

        for (Item notLentItem : notLentItems) {
            if (notLentItem.getCategory().getId() == category.getId()) {
                items.add(notLentItem);
            }
        }

        LoanDao loanDao = ObjectFactory.INSTANCE.getLoanDao();
        List<Loan> loans = loanDao.getLoans();

        for (Loan loan : loans) {
            if ((loan.isLentToMe() && lentToMeCheckBox) || (!loan.isLentToMe() && lentByMeCheckBox)) {
                Item item = loan.getItem();
                if (item.getCategory().getId() == category.getId()) {
                    System.out.println(loan.isLentToMe() + "=isLentToMe @DefaultItemManager");
                    items.add(loan.getItem());
                }
            }
        }
        return items;
    }
}
