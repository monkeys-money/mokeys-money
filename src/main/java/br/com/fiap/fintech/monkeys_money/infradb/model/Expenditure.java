package br.com.fiap.fintech.monkeys_money.infradb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Expenditure implements Serializable {

    private Long id;
    private User user;
    private String  expenditure;
    private String description;
    private BigDecimal amount;
    private LocalDateTime expenditureAt;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(String expenditure) {
        this.expenditure = expenditure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getExpenditureAt() {
        return expenditureAt;
    }

    public void setExpenditureAt(LocalDateTime expenditureAt) {
        this.expenditureAt = expenditureAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
