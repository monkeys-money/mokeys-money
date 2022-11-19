package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue;

import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;

import java.util.List;
import java.util.Map;

public interface IFindRevenueUseCase {

    Revenue findOne(final Map<Object, Object> params);

    List<Revenue> findMany(final Map<Object, Object> params);
}
