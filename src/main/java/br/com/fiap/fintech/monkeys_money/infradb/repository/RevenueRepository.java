package br.com.fiap.fintech.monkeys_money.infradb.repository;

import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.Repository;

import java.util.List;
import java.util.Map;

public class RevenueRepository implements Repository<Revenue> {
    @Override
    public Revenue save(Revenue revenue) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Revenue update(Revenue revenue) {
        return null;
    }

    @Override
    public List<Revenue> findMany(Map<String, Object> params) {
        return null;
    }

    @Override
    public Revenue findOne(Map<String, Object> params) {
        return null;
    }
}
