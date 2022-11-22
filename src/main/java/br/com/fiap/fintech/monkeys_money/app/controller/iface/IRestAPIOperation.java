package br.com.fiap.fintech.monkeys_money.app.controller.iface;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IRestAPIOperation {

    void save(HttpServletRequest request, HttpServletResponse response);

    void find(HttpServletRequest request, HttpServletResponse response);

    void update(HttpServletRequest request, HttpServletResponse response);

    void delete(HttpServletRequest request, HttpServletResponse response);

    void unsupported(HttpServletRequest request, HttpServletResponse response);
}
