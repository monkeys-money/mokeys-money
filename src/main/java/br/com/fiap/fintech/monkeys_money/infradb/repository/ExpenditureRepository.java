package br.com.fiap.fintech.monkeys_money.infradb.repository;

import br.com.fiap.fintech.monkeys_money.infradb.model.Expenditure;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.Repository;

import java.util.List;
import java.util.Map;

public class ExpenditureRepository implements Repository<Expenditure> {
    @Override
    public Expenditure save(Expenditure expense) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Expenditure update(Expenditure expense) {
        return null;
    }

    @Override
    public List<Expenditure> findMany(Map<String, Object> params) {
        return null;
    }

    @Override
    public Expenditure findOne(Map<String, Object> params) {
        return null;
    }
}
