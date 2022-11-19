package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment;

import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;

import java.util.List;
import java.util.Map;

public interface IFindInvestmentUseCase {

    Investment findOne(final Map<Object, Object> params);

    List<Investment> findMany(final Map<Object, Object> params);
}
