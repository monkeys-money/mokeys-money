package br.com.fiap.fintech.monkeys_money.cross.auth;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.Ed25519Signer;
import com.nimbusds.jose.crypto.Ed25519Verifier;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.OctetKeyPair;
import com.nimbusds.jose.jwk.gen.OctetKeyPairGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class JWT {

    private static OctetKeyPair key() throws JOSEException {
        return new OctetKeyPairGenerator(Curve.Ed25519)
                .keyID("123")
                .generate();

    }

    private static JWSHeader header() throws JOSEException {
        return new JWSHeader.Builder(JWSAlgorithm.EdDSA)
                .type(JOSEObjectType.JWT)
                .keyID(JWT.key().getKeyID())
                .build();
    }

    public JWTClaimsSet createPayloadToken(final String subject, final List<String> roles){
        return new JWTClaimsSet.Builder()
                .issuer("monkeysmoney.com")
                .subject(subject)
                .claim("roles", roles)
                .expirationTime(Date.from(Instant.now().plusSeconds(120)))
                .build();
    }

    public String signJWT(JWTClaimsSet payload) throws JOSEException {
        var signedJWT = new SignedJWT(JWT.header(), payload);

        //Sign
        signedJWT.sign(new Ed25519Signer(JWT.key()));

        //serialize the token
        return signedJWT.serialize();
    }

    public boolean parseJWT(final String jwt) throws JOSEException, ParseException {
        JWSVerifier verifier = new Ed25519Verifier(JWT.key().toPublicJWK());

        return SignedJWT.parse(jwt)
                .verify(verifier);
    }

}
