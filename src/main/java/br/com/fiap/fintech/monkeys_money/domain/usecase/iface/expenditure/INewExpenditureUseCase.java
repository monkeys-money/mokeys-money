package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure;

import java.sql.SQLException;

import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;

public interface INewExpenditureUseCase {

    Expenditure save(Expenditure expenditure) throws SQLException;
}
