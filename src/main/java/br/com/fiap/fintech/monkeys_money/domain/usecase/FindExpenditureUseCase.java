package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure.IFindExpenditureUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.repository.ExpenditureRepository;

public class FindExpenditureUseCase implements IFindExpenditureUseCase{
	
	private ExpenditureRepository repository;
	
	public FindExpenditureUseCase() {
		repository = new ExpenditureRepository();
	}

	@Override
	public Expenditure findOne(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expenditure> findMany(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expenditure> findByLast30Days(final Long userId) {
		return repository.findByLast30Days(userId);
	}

}
