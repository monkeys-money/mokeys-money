package br.com.fiap.fintech.monkeys_money.domain.usecase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nimbusds.jose.JOSEException;

import br.com.fiap.fintech.monkeys_money.cross.auth.JWT;
import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.login.ILoginUserCase;
import br.com.fiap.fintech.monkeys_money.infradb.repository.UserRepository;

public class LoginUserCase implements ILoginUserCase {

    private UserRepository userRepository;

    public LoginUserCase(){
        userRepository = new UserRepository();
    }

    @Override
    public String authenticate(String user, String password) throws UserAuthenticateException {

        Map<String, Object> params = new HashMap<>();
        params.put("email",  user);

        var u = userRepository.findOne(params);

        if(u != null && (u.getEmail() == user && u.getPassword() == password)){

            var jwt = new JWT();

            try {
                return jwt.signJWT(jwt.createPayloadToken(u.getEmail(), getRoles()));
            } catch (JOSEException e) {
                throw new UserAuthenticateException("Error to Generate Toke");
            }
        }else{
            throw new UserAuthenticateException("User Or Password Incorrect.");
        }
    }

    final List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        roles.add("basic");

        return roles;
    }
}
