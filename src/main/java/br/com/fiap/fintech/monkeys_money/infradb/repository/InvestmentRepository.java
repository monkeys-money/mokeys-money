package br.com.fiap.fintech.monkeys_money.infradb.repository;

import br.com.fiap.fintech.monkeys_money.infradb.model.Investment;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.Repository;

import java.util.List;
import java.util.Map;

public class InvestmentRepository implements Repository<Investment> {
    @Override
    public Investment save(Investment investment) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Investment update(Investment investment) {
        return null;
    }

    @Override
    public List<Investment> findMany(Map<String, Object> params) {
        return null;
    }

    @Override
    public Investment findOne(Map<String, Object> params) {
        return null;
    }
}
