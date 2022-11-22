package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment;

import java.sql.SQLException;

import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;

public interface INewInvestmentUseCase {
	
	Investment save(Investment investment) throws SQLException;
}
