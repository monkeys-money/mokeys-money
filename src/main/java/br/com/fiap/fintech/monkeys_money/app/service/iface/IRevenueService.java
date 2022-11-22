package br.com.fiap.fintech.monkeys_money.app.service.iface;

import java.util.List;
import java.util.Map;

import br.com.fiap.fintech.monkeys_money.app.dto.response.RevenueResponse;

public interface IRevenueService<T, E> extends IService<T, E> {

    List<T> findMany(Map<String, Object> params);
    
    List<RevenueResponse> findByLast30Days(final Long userId);
}
