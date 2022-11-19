package br.com.fiap.fintech.monkeys_money.infradb.repository;

import br.com.fiap.fintech.monkeys_money.infradb.model.Profile;
import br.com.fiap.fintech.monkeys_money.infradb.repository.iface.Repository;

import java.util.List;
import java.util.Map;

public class ProfileRepository implements Repository<Profile> {
    @Override
    public Profile save(Profile profile) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Profile update(Profile profile) {
        return null;
    }

    @Override
    public List<Profile> findMany(Map<String, Object> params) {
        throw new UnsupportedOperationException("This operation is not supported to Profile");
    }

    @Override
    public Profile findOne(Map<String, Object> params) {
        return null;
    }
}
