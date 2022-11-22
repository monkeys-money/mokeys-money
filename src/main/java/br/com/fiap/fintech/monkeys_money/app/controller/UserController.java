package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.fiap.fintech.monkeys_money.app.controller.iface.IRestAPIOperation;
import br.com.fiap.fintech.monkeys_money.app.dto.request.UserRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.app.service.UserService;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IUserService;
import br.com.fiap.fintech.monkeys_money.cross.gson.GsonWrapper;
import br.com.fiap.fintech.monkeys_money.cross.util.ServletPrintWriterHelper;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/users", name = "UserController")
public class UserController extends GenericServlet implements IRestAPIOperation {

	private static final long serialVersionUID = 8425521879075714836L;

	IUserService<UserResponse, UserRequest> userService = null;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;

		userService = new UserService();

		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;

			var method = request.getMethod();

			switch (method) {
			case "POST":
				this.save(request, response);
				break;
			case "GET":
				this.find(request, response);
				break;
			case "DELETE":
				this.delete(request, response);
				break;
			case "PUT":
				this.update(request, response);
				break;
			default:
				this.unsupported(request, response);
				break;

			}

		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}

	}

	@Override
	public void save(HttpServletRequest request, HttpServletResponse response) {
		try {
			var user = new Gson().fromJson(request.getReader(), UserRequest.class);

			if (user.getEmail().isBlank() || user.getPassword().isBlank()) {

				ServletPrintWriterHelper.badRequest(response);

			} else {

				var userResponse = userService.save(user);
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(userResponse));
			}

		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
			ServletPrintWriterHelper.internalServerError(response);
		} catch (SQLException e) {
			e.printStackTrace();
			ServletPrintWriterHelper.internalServerError(response);
		}
	}

	@Override
	public void find(HttpServletRequest request, HttpServletResponse response) {

		var email = request.getParameter("email");

		if (email != null && email != "") {

			Map<String, Object> query = new HashMap<>();
			query.put("email", email);

			var userResponse = userService.findOne(query);

			ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(userResponse));

		} else {

			ServletPrintWriterHelper.badRequest(response);
		}

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unsupported(HttpServletRequest request, HttpServletResponse response) {
		ServletPrintWriterHelper.unSupported(response);
	}

}
