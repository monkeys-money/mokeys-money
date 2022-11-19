package br.com.fiap.fintech.monkeys_money.infradb.repository.iface;

import java.util.List;
import java.util.Map;

public interface Repository<T> {

    T save(T t);

    Boolean delete(final Long id);

    T update(T t);

    List<T> findMany(final Map<String, Object> params);

    T findOne(final Map<String, Object> params);
}
