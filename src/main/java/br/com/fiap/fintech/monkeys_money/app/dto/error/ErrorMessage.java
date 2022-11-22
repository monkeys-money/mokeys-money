package br.com.fiap.fintech.monkeys_money.app.dto.error;

public class ErrorMessage {

	private String error;
	private int statusCode;
	
	public ErrorMessage(String err, int code) {
		this.error = err;
		this.statusCode = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
