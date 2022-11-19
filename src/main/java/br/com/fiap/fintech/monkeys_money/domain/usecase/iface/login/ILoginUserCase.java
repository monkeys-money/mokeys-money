package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.login;

import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;

public interface ILoginUserCase {

    String authenticate(final String user, final String password) throws UserAuthenticateException;
}
