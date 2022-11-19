package br.com.fiap.fintech.monkeys_money.domain.usecase;

import br.com.fiap.fintech.monkeys_money.cross.auth.JWT;
import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.login.ILoginUserCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.time.Instant;
import java.util.*;

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
