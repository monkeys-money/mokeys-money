package br.com.fiap.fintech.monkeys_money.app.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RevenueRequest {

	private Long userId;
	private String revenue;
	private String description;
	private BigDecimal amount;
	private LocalDateTime revenueAt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
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

	public LocalDateTime getRevenueAt() {
		return revenueAt;
	}

	public void setRevenueAt(LocalDateTime revenueAt) {
		this.revenueAt = revenueAt;
	}

}
