package sk.upjs.paz1c.nezabudal.dao;


import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.dao.CategoryDao;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.ItemDao;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dao.LoanDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyCategoryDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyItemDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyItemDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyLoanDao;
import sk.upjs.paz1c.nezabudal.dummy.data.DummyLoanDao;
import sk.upjs.paz1c.nezabudal.gui.models.CategoryComboBoxModel;
import sk.upjs.paz1c.nezabudal.gui.models.ItemComboBoxModel;
import sk.upjs.paz1c.nezabudal.gui.models.LoanComboBoxModel;



public enum ObjectFactory {
    INSTANCE;
    
    // private JdbcTemplate jdbcTemplate;
    
    private CategoryDao categoryDao;
    private LoanDao loanDao;
    private ItemDao itemDao;
    
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
    
     public LoanDao getLoanDao() {
        if (loanDao == null) {
            loanDao = new DummyLoanDao();            
        }
        return loanDao;
    }
     
      public ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new DummyItemDao();            
        }
        return itemDao;
    }
      
      public CategoryComboBoxModel getCategoryComboBoxModel() {
          if (categoryComboBoxModel == null) {
              categoryComboBoxModel = new CategoryComboBoxModel();
          }
          return categoryComboBoxModel;
      }
    
}
