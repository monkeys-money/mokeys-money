package br.com.fiap.fintech.monkeys_money.app.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenditureRequest {

	private Long userId;
	private String expenditure;
	private String description;
	private BigDecimal amount;
	private LocalDateTime expenditureAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

}
