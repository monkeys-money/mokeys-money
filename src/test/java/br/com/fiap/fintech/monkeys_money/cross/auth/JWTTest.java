package br.com.fiap.fintech.monkeys_money.cross.auth;

import br.com.fiap.fintech.monkeys_money.cross.excep.UserAuthenticateException;
import com.nimbusds.jose.JOSEException;

import junit.framework.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JWTTest {

    @Test
    public void getToken(){
        var jwt = new JWT();
        try {
            var token = jwt.signJWT(jwt.createPayloadToken("lhs.ribas@gmail.com", getRoles()));
            Assert.assertNotNull(token);
        } catch (JOSEException e) {
            Assert.fail();
        }
    }

    @Test
    public void parseToken(){
        var jwt = new JWT();

        try {
            var token = jwt.signJWT(jwt.createPayloadToken("lhs.ribas@gmail.com", getRoles()));
            var j = jwt.parseJWT(token);
            Assert.assertEquals(true, j);
        } catch (JOSEException | ParseException e) {
            Assert.fail();
        }
    }

    final List<String> getRoles(){
        List<String> roles = new ArrayList<>();
        roles.add("basic");

        return roles;
    }
}
