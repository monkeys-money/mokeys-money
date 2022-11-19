package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure;

import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;

import java.util.List;
import java.util.Map;

public interface IFindExpenditureUseCase {

    Expenditure findOne(final Map<Object, Object> params);

    List<Expenditure> findMany(final Map<Object, Object> params);
}
