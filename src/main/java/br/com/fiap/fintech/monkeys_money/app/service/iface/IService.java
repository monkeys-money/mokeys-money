package br.com.fiap.fintech.monkeys_money.app.service.iface;

import java.sql.SQLException;
import java.util.Map;

public interface IService<T, E> {

    T save(E e) throws SQLException;

    T findOne(Map<String, Object> params);

    T update(E e);

    Boolean delete(final Long id);
}
