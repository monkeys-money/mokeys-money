package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.profile;

import br.com.fiap.fintech.monkeys_money.infradb.model.Profile;
import br.com.fiap.fintech.monkeys_money.infradb.model.Revenue;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public interface IFindProfileUseCase {

    Profile findOne(final Map<Object, Object> params);
}
