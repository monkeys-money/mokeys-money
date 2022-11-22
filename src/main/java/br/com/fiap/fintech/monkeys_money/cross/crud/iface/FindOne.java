package br.com.fiap.fintech.monkeys_money.cross.crud.iface;

import java.util.Map;

public interface FindOne<T> {
    T of(Map<String, Object> params);
}
