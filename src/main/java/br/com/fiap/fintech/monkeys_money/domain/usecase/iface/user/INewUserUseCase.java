package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user;

import br.com.fiap.fintech.monkeys_money.cross.crud.iface.Save;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

public interface INewUserUseCase extends Save<User> {

}
