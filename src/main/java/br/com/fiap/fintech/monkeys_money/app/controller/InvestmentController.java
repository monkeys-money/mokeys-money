package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.fiap.fintech.monkeys_money.app.controller.iface.IRestAPIOperation;
import br.com.fiap.fintech.monkeys_money.app.dto.request.InvestmentRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.InvestmentResponse;
import br.com.fiap.fintech.monkeys_money.app.service.InvestmentService;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IInvestmentService;
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

@WebServlet(value = "/investments", name = "InvestmentController")
public class InvestmentController extends GenericServlet implements IRestAPIOperation {

	private static final long serialVersionUID = 3206423582749483019L;
	private IInvestmentService<InvestmentResponse, InvestmentRequest> investmentService = null;

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;

		investmentService = new InvestmentService();

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
			var investment = new GsonWrapper().of().fromJson(request.getReader(), InvestmentRequest.class);

			if (Objects.nonNull(investment.getAmount()) || !investment.getInvestment().isBlank()
					|| !investment.getDescription().isBlank() || Objects.nonNull(investment.getUserId())) {

				var investmentResponse = investmentService.save(investment);
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(investmentResponse));

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
		
			var investmentResponses = investmentService.findByLast30Days(Long.parseLong(userId));

			if (investmentResponses.size() > 0) {
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(investmentResponses));
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
