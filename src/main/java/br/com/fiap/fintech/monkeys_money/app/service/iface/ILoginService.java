package br.com.fiap.fintech.monkeys_money.app.service.iface;

import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;

public interface ILoginService {

    String doLogin(final String user, final String password) throws UserAuthenticateException;
}
