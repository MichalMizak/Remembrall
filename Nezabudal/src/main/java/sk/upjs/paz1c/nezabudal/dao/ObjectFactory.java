package sk.upjs.paz1c.nezabudal.dao;

import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyItemDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyLoanDao;
import sk.upjs.paz1c.nezabudal.managers.implementations.DefaultItemManager;
import sk.upjs.paz1c.nezabudal.managers.ItemManager;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.managers.CategoryManager;
import sk.upjs.paz1c.nezabudal.managers.implementations.DefaultCategoryManager;
import sk.upjs.paz1c.nezabudal.managers.implementations.DefaultLoanManager;
import sk.upjs.paz1c.nezabudal.managers.LoanManager;

public enum ObjectFactory {
    INSTANCE;

    // private JdbcTemplate jdbcTemplate;
    private CategoryDao categoryDao;
    private LoanDao loanDao;
    private ItemDao itemDao;

    private ItemManager itemManager;
    private CategoryManager categoryManager;
    private LoanManager loanManager;

    private CategoryComboBoxModel categoryComboBoxModel;

    /* public JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/debilnicek?serverTimezone=UTC");
            dataSource.setUser("debilnicek");
            dataSource.setPassword("debilnicek");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;        
    } */
    public CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new DummyCategoryDao();
        }
        return categoryDao;
    }

    public LoanManager getLoanManager() {
        if (loanManager == null) {
            loanManager = new DefaultLoanManager();
        }
        return loanManager;
    }

    public ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new DummyItemDao();
        }
        return itemDao;
    }

    public CategoryManager getCategoryManager() {
        if (categoryManager == null) {
            categoryManager = new DefaultCategoryManager();
        }
        return categoryManager;
    }

    public LoanDao getLoanDao() {
        if (loanDao == null) {
            loanDao = new DummyLoanDao();
        }
        return loanDao;
    }
    
    
    public ItemManager getItemManager() {
        if (itemManager == null) {
            itemManager = new DefaultItemManager();
        }
        return itemManager;
    }

    public CategoryComboBoxModel getCategoryComboBoxModel() {
        if (categoryComboBoxModel == null) {
            categoryComboBoxModel = new CategoryComboBoxModel();
        }
        return categoryComboBoxModel;
    }

}
