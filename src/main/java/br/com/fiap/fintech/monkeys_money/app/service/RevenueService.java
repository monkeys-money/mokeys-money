package br.com.fiap.fintech.monkeys_money.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.app.dto.request.RevenueRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.RevenueResponse;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IRevenueService;
import br.com.fiap.fintech.monkeys_money.cross.mapper.RevenueMapper;
import br.com.fiap.fintech.monkeys_money.domain.usecase.FindRevenueUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.NewRevenueUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue.IFindRevenueUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.revenue.INewRevenueUseCase;

public class RevenueService implements IRevenueService<RevenueResponse, RevenueRequest> {
	
	private INewRevenueUseCase newUseCase;
	private IFindRevenueUseCase findUseCase;
	
	public RevenueService() {
		newUseCase = new NewRevenueUseCase();
		findUseCase = new FindRevenueUseCase();
	}

	@Override
	public RevenueResponse save(RevenueRequest e) throws SQLException {
		// build object db
		var revenue = RevenueMapper.requestToDB(e);
		
		// return response
		return RevenueMapper.dbToResponse(newUseCase.save(revenue));
	}

	@Override
	public RevenueResponse findOne(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevenueResponse update(RevenueRequest e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RevenueResponse> findMany(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<RevenueResponse> findByLast30Days(final Long userId) {
		return RevenueMapper.dbToResponses(findUseCase.findByLast30Days(userId));
	}

}
