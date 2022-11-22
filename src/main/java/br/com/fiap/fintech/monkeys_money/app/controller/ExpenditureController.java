package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.fiap.fintech.monkeys_money.app.controller.iface.IRestAPIOperation;
import br.com.fiap.fintech.monkeys_money.app.dto.request.ExpenditureRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.ExpenditureResponse;
import br.com.fiap.fintech.monkeys_money.app.service.ExpenditureService;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IExpenditureService;
import br.com.fiap.fintech.monkeys_money.cross.gson.GsonWrapper;
import br.com.fiap.fintech.monkeys_money.cross.util.ServletPrintWriterHelper;
import br.com.fiap.fintech.monkeys_money.cross.util.StringUtils;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/expenditures", name = "ExpenditureController")
public class ExpenditureController extends GenericServlet implements IRestAPIOperation {

	private static final long serialVersionUID = 3206423582749483019L;
	private IExpenditureService<ExpenditureResponse, ExpenditureRequest> expenditureService = null;

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;

		expenditureService = new ExpenditureService();

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
		try {
			var expenditure = new GsonWrapper().of().fromJson(request.getReader(), ExpenditureRequest.class);

			if (Objects.nonNull(expenditure.getAmount()) || !expenditure.getExpenditure().isBlank()
					|| !expenditure.getDescription().isBlank() || Objects.nonNull(expenditure.getUserId())) {

				var expenditureResponse = expenditureService.save(expenditure);
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(expenditureResponse));

			}

		} catch (JsonSyntaxException | JsonIOException | IOException | SQLException e) {
			e.printStackTrace();
			ServletPrintWriterHelper.internalServerError(response);
		}
	}

	@Override
	public void find(HttpServletRequest request, HttpServletResponse response) {
		
		var userId = request.getParameter("userId");
		
		if(userId.isEmpty() || !StringUtils.isNumeric(userId)) {
			ServletPrintWriterHelper.badRequest(response);
		} else {
		
			var expenditureResponses = expenditureService.findByLast30Days(Long.parseLong(userId));

			if (expenditureResponses.size() > 0) {
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(expenditureResponses));
			} else {
				ServletPrintWriterHelper.notcontent(response);
			}
		}
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {

	}

	@Override
	public void unsupported(HttpServletRequest request, HttpServletResponse response) {
		ServletPrintWriterHelper.unSupported(response);
	}
}
