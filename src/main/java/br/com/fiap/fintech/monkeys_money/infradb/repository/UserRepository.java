package br.com.fiap.fintech.monkeys_money.infradb.repository;

import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.Repository;

import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {

    @Override
    public User save(User login) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public User update(User login) {
        return null;
    }

    @Override
    public List<User> findMany(Map<String, Object> params) {
        throw new UnsupportedOperationException("This operation is not supported to Login");
    }

    @Override
    public User findOne(Map<String, Object> params) {
        return null;
    }
}
