package br.com.fiap.fintech.monkeys_money.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.app.dto.request.ExpenditureRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.ExpenditureResponse;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IExpenditureService;
import br.com.fiap.fintech.monkeys_money.cross.mapper.ExpenditureMapper;
import br.com.fiap.fintech.monkeys_money.domain.usecase.FindExpenditureUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.NewExpenditureUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure.IFindExpenditureUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.expenditure.INewExpenditureUseCase;

public class ExpenditureService implements IExpenditureService<ExpenditureResponse, ExpenditureRequest> {
	
	private INewExpenditureUseCase newUseCase;
	private IFindExpenditureUseCase findUseCase;
	
	public ExpenditureService() {
		newUseCase = new NewExpenditureUseCase();
		findUseCase = new FindExpenditureUseCase();
	}

	@Override
	public ExpenditureResponse save(ExpenditureRequest e) throws SQLException {
		// build object db
		var expenditure = ExpenditureMapper.requestToDB(e);
		
		// return response
		return ExpenditureMapper.dbToResponse(newUseCase.save(expenditure));
	}

	@Override
	public ExpenditureResponse findOne(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExpenditureResponse update(ExpenditureRequest e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpenditureResponse> findMany(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ExpenditureResponse> findByLast30Days(final Long userId) {
		return ExpenditureMapper.dbToResponses(findUseCase.findByLast30Days(userId));
	}

}
