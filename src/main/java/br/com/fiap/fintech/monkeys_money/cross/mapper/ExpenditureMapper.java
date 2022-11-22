package br.com.fiap.fintech.monkeys_money.cross.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.app.dto.request.ExpenditureRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.ExpenditureResponse;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public class ExpenditureMapper {
	
	public static Expenditure requestToDB(final ExpenditureRequest request) {
		Objects.nonNull(request);
		
		var expenditure  = new Expenditure();
		
		expenditure.setAmount(request.getAmount());
		expenditure.setDescription(request.getDescription());
		expenditure.setExpenditure(request.getExpenditure());
		
		var user = new User();
		user.setId(request.getUserId());
		
		expenditure.setUser(user);
		
		return expenditure;
	}
	
	public static ExpenditureResponse dbToResponse(final Expenditure expenditure) {
		Objects.nonNull(expenditure);
		
		var response  = new ExpenditureResponse();
		
		response.setId(expenditure.getId());
		response.setAmount(expenditure.getAmount());
		response.setExpenditure(expenditure.getExpenditure());
		response.setDescription(expenditure.getDescription());
		response.setExpenditureAt(expenditure.getExpenditureAt());
		response.setCreateAt(expenditure.getCreateAt());
		response.setUpdatedAt(expenditure.getUpdatedAt());
		
		var user = new UserResponse();
		
		user.setId(expenditure.getUser().getId());
		user.setEmail(expenditure.getUser().getEmail());
		
		response.setUser(user);
		
		return response;
	}
	
	public static List<ExpenditureResponse> dbToResponses(final List<Expenditure> expenditures) {
		Objects.nonNull(expenditures);
		
		List<ExpenditureResponse> responses = new ArrayList<>();
		
		for (Expenditure expenditure : expenditures) {
			responses.add(dbToResponse(expenditure));
		}
		
		return responses;
	}

}
