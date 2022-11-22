package br.com.fiap.fintech.monkeys_money.cross.crud.iface;

import java.util.List;
import java.util.Map;

public interface FindMany<T> {
    List<T> of(Map<String, Object> params);
}
