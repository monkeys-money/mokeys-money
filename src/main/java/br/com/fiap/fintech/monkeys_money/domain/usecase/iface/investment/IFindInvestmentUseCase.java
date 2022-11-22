package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;

public interface IFindInvestmentUseCase {

    Investment findOne(final Map<Object, Object> params);

    List<Investment> findMany(final Map<Object, Object> params);
    
    List<Investment> findByLast30Days(Long userId);
}
