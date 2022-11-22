package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment.IFindInvestmentUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.repository.InvestmentRepository;

public class FindInvestmentUseCase implements IFindInvestmentUseCase{
	
	private InvestmentRepository repository;
	
	public FindInvestmentUseCase() {
		repository = new InvestmentRepository();
	}

	@Override
	public Investment findOne(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> findMany(Map<Object, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Investment> findByLast30Days(final Long userId) {
		return repository.findByLast30Days(userId);
	}

}
