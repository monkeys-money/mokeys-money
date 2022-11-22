package br.com.fiap.fintech.monkeys_money.app.service;

import br.com.fiap.fintech.monkeys_money.app.service.iface.ILoginService;
import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;
import br.com.fiap.fintech.monkeys_money.domain.usecase.LoginUserCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.login.ILoginUserCase;

public class LoginService implements ILoginService {

    private ILoginUserCase userCase;

    public LoginService() {
        userCase = new LoginUserCase();
    }

    @Override
    public String doLogin(String user, String password) throws UserAuthenticateException {
        return userCase.authenticate(user, password);
    }

}
