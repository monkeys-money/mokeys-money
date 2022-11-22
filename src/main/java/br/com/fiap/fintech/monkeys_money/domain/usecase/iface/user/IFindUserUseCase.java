package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user;

import br.com.fiap.fintech.monkeys_money.cross.crud.iface.FindOne;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public interface IFindUserUseCase extends FindOne<User> {

}
