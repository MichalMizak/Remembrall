package sk.upjs.paz1c.nezabudal.managers.implementations;

import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.other.ObjectFactory;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.entity.Attribute;
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
    public List<Item> getBorrowedItems(){
        return itemDao.getItems(true);
    }

    // other filters
    
    @Override
    public List<Item> getItemsBorrowedToMe() {
        List<Item> borrowedItems = itemDao.getItems(true);
        List<Item> itemsBorrowedToMe = new ArrayList<>();

        for (Item item : borrowedItems) {
            Loan loan = loanDao.getByItem(item);
            if (loan.isLentToMe()) {
                itemsBorrowedToMe.add(item);
            }
        }

        return itemsBorrowedToMe;
    }

    @Override
    public List<Item> getItemsLentByMe() {
        List<Item> borrowedItems = itemDao.getItems(true);
        List<Item> itemsLentByMe = new ArrayList<>();

        for (Item item : borrowedItems) {
            Loan loan = loanDao.getByItem(item);
            if (!loan.isLentToMe()) {
                itemsLentByMe.add(item);
            }
        }

        return itemsLentByMe;
    }
}
