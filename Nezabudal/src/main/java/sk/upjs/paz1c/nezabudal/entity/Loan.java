package sk.upjs.paz1c.nezabudal.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mikey
 */
public class Loan {

    private Long id;

    private Item item;

    private String specification;

    private boolean lentToMe;

    private String person;    
    
    private LocalDateTime startDate;
    
    private LocalDateTime returnDate;

    public Loan(Item item, String specification, boolean borrowedToMe, String person, LocalDateTime startDate, LocalDateTime returnDate) {
        this.item = item;
        this.specification = specification;
        this.lentToMe = borrowedToMe;
        this.person = person;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public Loan() {
    }
    
    
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public boolean isLentToMe() {
        return lentToMe;
    }

    public void setLentToMe(boolean lentToMe) {
        this.lentToMe = lentToMe;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return specification;
    }

    
}
