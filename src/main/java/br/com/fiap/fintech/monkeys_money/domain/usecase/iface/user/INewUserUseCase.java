package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user;

import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public interface INewUserUseCase {

    User save(User user);
}
