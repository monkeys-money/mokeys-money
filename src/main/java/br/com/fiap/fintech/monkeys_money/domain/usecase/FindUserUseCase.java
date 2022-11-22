package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.util.Map;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user.IFindUserUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.UserRepository;

public class FindUserUseCase implements IFindUserUseCase{
	
	private UserRepository repository;
	
	public FindUserUseCase() {
		repository = new UserRepository();
	}

	@Override
	public User of(Map<String, Object> params) {
		return repository.findOne(params);
	}

}
