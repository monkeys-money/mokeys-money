package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user;

import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public interface IFindUserUseCase {

    User findOne(final String email);
}
