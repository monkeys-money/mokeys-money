package br.com.fiap.fintech.monkeys_money.app.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvestmentRequest {

	private Long userId;
	private String investment;
	private String description;
	private BigDecimal amount;
	private LocalDateTime investmentAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
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

	public LocalDateTime getInvestmentAt() {
		return investmentAt;
	}

	public void setInvestmentAt(LocalDateTime investmentAt) {
		this.investmentAt = investmentAt;
	}

}
