package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;

public interface IFindExpenditureUseCase {

    Expenditure findOne(final Map<Object, Object> params);

    List<Expenditure> findMany(final Map<Object, Object> params);
    
    List<Expenditure> findByLast30Days(Long userId);
}
