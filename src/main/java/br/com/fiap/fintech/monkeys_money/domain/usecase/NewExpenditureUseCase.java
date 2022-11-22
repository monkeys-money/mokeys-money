package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure.INewExpenditureUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.repository.ExpenditureRepository;

public class NewExpenditureUseCase implements INewExpenditureUseCase {
	
	private ExpenditureRepository repository;
	
	public NewExpenditureUseCase() {
		repository = new ExpenditureRepository();
	}

	@Override
	public Expenditure save(Expenditure expenditure) throws SQLException {
		
		if(Objects.isNull(expenditure.getExpenditureAt())) {
			expenditure.setExpenditureAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		}
		
		expenditure.setCreateAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
		return repository.save(expenditure);
	}

}
