package br.com.fiap.fintech.monkeys_money.cross.util;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import br.com.fiap.fintech.monkeys_money.app.dto.error.ErrorMessage;

public class ServletPrintWriterHelper {

	public static void unSupported(HttpServletResponse response) {
		PrintWriter out = null;
		try {
			response.setContentType("application/text");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);

			out = response.getWriter();
			out.print("Operation Unsupported.");
			out.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			out.close();
		}
	}

	public static void ok(HttpServletResponse response, final String body){
		PrintWriter out = null;
		try {
			response.setContentType("applicatin/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_OK);

			out = response.getWriter();
			out.print(body);
			out.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			out.close();
		}
	}

	public static void badRequest(HttpServletResponse response){
		PrintWriter out = null;
		try {
			var error = new ErrorMessage("Invalid Body.", 400);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
			out = response.getWriter();
			out.print(new Gson().toJson(error));
			out.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public static void notcontent(HttpServletResponse response){
		PrintWriter out = null;
		try {
			var error = new ErrorMessage("NO_CONTENT", 204);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			
			out = response.getWriter();
			out.print(new Gson().toJson(error));
			out.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public static void internalServerError(HttpServletResponse response) {
		PrintWriter out = null;
		try {
			var error = new ErrorMessage("Internal Error, Try more later again!", 400);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			
			out = response.getWriter();
			out.print(new Gson().toJson(error));
			out.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			out.close();
		}
	}
}
