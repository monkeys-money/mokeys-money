package br.com.fiap.fintech.monkeys_money.app.dto.response;

public class TokenResponse {

    private String token;

    public TokenResponse(){}

    public TokenResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
