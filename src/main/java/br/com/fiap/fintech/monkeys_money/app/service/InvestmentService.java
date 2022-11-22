package br.com.fiap.fintech.monkeys_money.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.app.dto.request.InvestmentRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.InvestmentResponse;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IInvestmentService;
import br.com.fiap.fintech.monkeys_money.cross.mapper.InvestmentMapper;
import br.com.fiap.fintech.monkeys_money.domain.usecase.FindInvestmentUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.NewInvestmentUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment.IFindInvestmentUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.investment.INewInvestmentUseCase;

public class InvestmentService implements IInvestmentService<InvestmentResponse, InvestmentRequest> {
	
	private INewInvestmentUseCase newUseCase;
	private IFindInvestmentUseCase findUseCase;
	
	public InvestmentService() {
		newUseCase = new NewInvestmentUseCase();
		findUseCase = new FindInvestmentUseCase();
	}

	@Override
	public InvestmentResponse save(InvestmentRequest e) throws SQLException {
		// build object db
		var investment = InvestmentMapper.requestToDB(e);
		
		// return response
		return InvestmentMapper.dbToResponse(newUseCase.save(investment));
	}

	@Override
	public InvestmentResponse findOne(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InvestmentResponse update(InvestmentRequest e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvestmentResponse> findMany(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<InvestmentResponse> findByLast30Days(final Long userId) {
		return InvestmentMapper.dbToResponses(findUseCase.findByLast30Days(userId));
	}

}
