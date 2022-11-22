package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue;

import java.sql.SQLException;

import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;

public interface INewRevenueUseCase {

    Revenue save(Revenue revenue) throws SQLException;
}
