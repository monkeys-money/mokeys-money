package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.fiap.fintech.monkeys_money.app.controller.iface.IRestAPIOperation;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/profiles", name = "ProfileController")
public class ProfileController extends GenericServlet implements IRestAPIOperation {

	private static final long serialVersionUID = 8221109853832304834L;

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

	}

	@Override
	public void find(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void unsupported(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/text");
		PrintWriter out = null;

		try {

			out = response.getWriter();
			out.println("Operation Unsupported.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
