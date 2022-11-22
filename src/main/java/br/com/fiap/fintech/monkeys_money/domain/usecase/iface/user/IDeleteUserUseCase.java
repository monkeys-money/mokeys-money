package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user;

import br.com.fiap.fintech.monkeys_money.cross.crud.iface.Delete;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public interface IDeleteUserUseCase extends Delete<User> {

}
