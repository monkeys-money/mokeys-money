package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue.INewRevenueUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;
import br.com.fiap.fintech.monkeys_money.infradb.repository.RevenueRepository;

public class NewRevenueUseCase implements INewRevenueUseCase {
	
	private RevenueRepository repository;
	
	public NewRevenueUseCase() {
		repository = new RevenueRepository();
	}

	@Override
	public Revenue save(Revenue revenue) throws SQLException {
		
		if(Objects.isNull(revenue.getRevenueAt())) {
			revenue.setRevenueAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		}
		
		revenue.setCreateAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		return repository.save(revenue);
	}

}
