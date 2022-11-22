package br.com.fiap.fintech.monkeys_money.infradb.repository.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface Repository<T> {

    T save(T t) throws SQLException;

    Boolean delete(final Long id) throws SQLException;

    T update(T t) throws SQLException;

    List<T> findMany(final Map<String, Object> params) throws SQLException;

    T findOne(final Map<String, Object> params) throws SQLException;
}
