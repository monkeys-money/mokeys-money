package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment.INewInvestmentUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.repository.InvestmentRepository;

public class NewInvestmentUseCase implements INewInvestmentUseCase {
	
	private InvestmentRepository repository;
	
	public NewInvestmentUseCase() {
		repository = new InvestmentRepository();
	}

	@Override
	public Investment save(Investment investment) throws SQLException {
		
		if(Objects.isNull(investment.getInvestmentAt())) {
			investment.setInvestmentAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		}
		
		investment.setCreateAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		return repository.save(investment);
	}

}
