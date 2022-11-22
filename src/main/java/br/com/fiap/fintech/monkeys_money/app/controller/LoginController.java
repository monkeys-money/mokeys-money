package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;

import com.google.gson.Gson;

import br.com.fiap.fintech.monkeys_money.app.service.LoginService;
import br.com.fiap.fintech.monkeys_money.app.service.iface.ILoginService;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/login", name = "LoginController")
public class LoginController extends GenericServlet {

	private static final long serialVersionUID = -6880671455974574918L;

	private ILoginService service;
	private Gson gson;

	public LoginController() {
		service = new LoginService();
		gson = new Gson();
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;

		try {
			request = (HttpServletRequest) servletRequest;
			response = (HttpServletResponse) servletResponse;

			var method = request.getMethod();

			switch (method) {
			case "POST":
				this.autehticate(request, response);
			}

		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
	}

	protected void autehticate(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * try {
		 * 
		 * var token = service.doLogin(request.getHeader("username"),
		 * request.getHeader("password")); var tokenResponse = new TokenResponse(
		 * token);
		 * 
		 * PrintWriter out = null;
		 * 
		 * try { var body = this.gson.toJson(tokenResponse);
		 * 
		 * out = new ServletPrintWriterHelper().getPrintWriter(response, body,
		 * "application/json"); out.flush();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); } finally { out.close(); }
		 * 
		 * } catch (UserAuthenticateException e) { e.printStackTrace(); }
		 */

	}

}
