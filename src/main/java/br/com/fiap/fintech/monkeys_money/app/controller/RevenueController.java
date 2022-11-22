package br.com.fiap.fintech.monkeys_money.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import br.com.fiap.fintech.monkeys_money.app.controller.iface.IRestAPIOperation;
import br.com.fiap.fintech.monkeys_money.app.dto.request.RevenueRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.RevenueResponse;
import br.com.fiap.fintech.monkeys_money.app.service.RevenueService;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IRevenueService;
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

@WebServlet(value = "/revenues", name = "RevenueController")
public class RevenueController extends GenericServlet implements IRestAPIOperation {

	private static final long serialVersionUID = 3206423582749483019L;
	private IRevenueService<RevenueResponse, RevenueRequest> revenueService = null;

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse)
			throws ServletException, IOException {
		HttpServletRequest request;
		HttpServletResponse response;

		revenueService = new RevenueService();

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
			var revenue = new GsonWrapper().of().fromJson(request.getReader(), RevenueRequest.class);

			if (Objects.nonNull(revenue.getAmount()) || !revenue.getRevenue().isBlank()
					|| !revenue.getDescription().isBlank() || Objects.nonNull(revenue.getUserId())) {

				var revenueResponse = revenueService.save(revenue);
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(revenueResponse));

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
		
			var revenueResponses = revenueService.findByLast30Days(Long.parseLong(userId));

			if (revenueResponses.size() > 0) {
				ServletPrintWriterHelper.ok(response, new GsonWrapper().of().toJson(revenueResponses));
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
