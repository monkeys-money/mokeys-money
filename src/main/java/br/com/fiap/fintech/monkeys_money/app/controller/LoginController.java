package br.com.fiap.fintech.monkeys_money.app.controller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/login", name = "LoginController")
public class LoginController extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request;
        HttpServletResponse response;

        try{
            request = (HttpServletRequest)  servletRequest;
            response = (HttpServletResponse) servletResponse;

            var method = request.getMethod();

            switch (method) {
                case "POST":
                    this.doPost(request, response);
            }

        }catch(ClassCastException e) {
            throw new ServletException("non-HTTP request or response");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");

        PrintWriter out = null;

        try {

            out = response.getWriter();
            out.println("<h1>Hello World example using GenericServlet class.</h1>");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}
