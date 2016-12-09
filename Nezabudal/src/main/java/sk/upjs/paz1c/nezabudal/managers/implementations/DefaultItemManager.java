package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.dao.ObjectFactory;
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
    private LoanDao loanDao = ObjectFactory.INSTANCE.getLoanDao();

    // DAO methods
    @Override
    public List<Item> getItems() {
        return itemDao.getItems();
    }

    @Override
    public void saveOrUpdate(Item item) {
        itemDao.saveOrUpdate(item);
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
    public List<Item> getUnborrowedItems() {
        return itemDao.getUnborrowedItems();
    }

    // other filters
    
    @Override
    public List<Item> getItemsBorrowedToMe() {
        List<Item> borrowedItems = itemDao.getBorrowedItems();
        List<Item> itemsBorrowedToMe = new ArrayList<>();

        for (Item item : borrowedItems) {
            Loan loan = loanDao.getByItem(item);
            if (loan.isBorrowedToMe()) {
                itemsBorrowedToMe.add(item);
            }
        }

        return itemsBorrowedToMe;
    }

    @Override
    public List<Item> getItemsLentByMe() {
        List<Item> borrowedItems = itemDao.getBorrowedItems();
        List<Item> itemsLentByMe = new ArrayList<>();

        for (Item item : borrowedItems) {
            Loan loan = loanDao.getByItem(item);
            if (!loan.isBorrowedToMe()) {
                itemsLentByMe.add(item);
            }
        }

        return itemsLentByMe;
    }

}
