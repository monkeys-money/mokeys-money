package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue.IFindRevenueUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;
import br.com.fiap.fintech.monkeys_money.infradb.repository.RevenueRepository;

public class FindRevenueUseCase implements IFindRevenueUseCase{
	
	private RevenueRepository repository;
	
	public FindRevenueUseCase() {
		repository = new RevenueRepository();
	}

	@Override
	public Revenue findOne(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Revenue> findMany(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Revenue> findByLast30Days(final Long userId) {
		return repository.findByLast30Days(userId);
	}

}
