package br.com.fiap.fintech.monkeys_money.cross.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.app.dto.request.InvestmentRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.InvestmentResponse;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public class InvestmentMapper {
	
	public static Investment requestToDB(final InvestmentRequest request) {
		Objects.nonNull(request);
		
		var investment  = new Investment();
		
		investment.setAmount(request.getAmount());
		investment.setDescription(request.getDescription());
		investment.setInvestment(request.getInvestment());
		
		var user = new User();
		user.setId(request.getUserId());
		
		investment.setUser(user);
		
		return investment;
	}
	
	public static InvestmentResponse dbToResponse(final Investment investment) {
		Objects.nonNull(investment);
		
		var response  = new InvestmentResponse();
		
		response.setId(investment.getId());
		response.setAmount(investment.getAmount());
		response.setInvestment(investment.getInvestment());
		response.setDescription(investment.getDescription());
		response.setInvestmentAt(investment.getInvestmentAt());
		response.setCreateAt(investment.getCreateAt());
		response.setUpdatedAt(investment.getUpdatedAt());
		
		var user = new UserResponse();
		
		user.setId(investment.getUser().getId());
		user.setEmail(investment.getUser().getEmail());
		
		response.setUser(user);
		
		return response;
	}
	
	public static List<InvestmentResponse> dbToResponses(final List<Investment> investments) {
		Objects.nonNull(investments);
		
		List<InvestmentResponse> responses = new ArrayList<>();
		
		for (Investment investment : investments) {
			responses.add(dbToResponse(investment));
		}
		
		return responses;
	}

}
