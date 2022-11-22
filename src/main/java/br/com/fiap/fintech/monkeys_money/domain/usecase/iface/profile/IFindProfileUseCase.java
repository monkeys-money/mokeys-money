package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.profile;

import java.util.Map;

import br.com.fiap.fintech.monkeys_money.infradb.model.Profile;

public interface IFindProfileUseCase {

    Profile findOne(final Map<Object, Object> params);
}
