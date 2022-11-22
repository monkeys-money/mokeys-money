package br.com.fiap.fintech.monkeys_money.cross.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.fiap.fintech.monkeys_money.app.dto.request.RevenueRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.RevenueResponse;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public class RevenueMapper {
	
	public static Revenue requestToDB(final RevenueRequest request) {
		Objects.nonNull(request);
		
		var revenue  = new Revenue();
		
		revenue.setAmount(request.getAmount());
		revenue.setDescription(request.getDescription());
		revenue.setRevenue(request.getRevenue());
		
		var user = new User();
		user.setId(request.getUserId());
		
		revenue.setUser(user);
		
		return revenue;
	}
	
	public static RevenueResponse dbToResponse(final Revenue revenue) {
		Objects.nonNull(revenue);
		
		var response  = new RevenueResponse();
		
		response.setId(revenue.getId());
		response.setAmount(revenue.getAmount());
		response.setRevenue(revenue.getRevenue());
		response.setDescription(revenue.getDescription());
		response.setRevenueAt(revenue.getRevenueAt());
		response.setCreateAt(revenue.getCreateAt());
		response.setUpdatedAt(revenue.getUpdatedAt());
		
		var user = new UserResponse();
		
		user.setId(revenue.getUser().getId());
		user.setEmail(revenue.getUser().getEmail());
		
		response.setUser(user);
		
		return response;
	}
	
	public static List<RevenueResponse> dbToResponses(final List<Revenue> revenues) {
		Objects.nonNull(revenues);
		
		List<RevenueResponse> responses = new ArrayList<>();
		
		for (Revenue revenue : revenues) {
			responses.add(dbToResponse(revenue));
		}
		
		return responses;
	}

}
