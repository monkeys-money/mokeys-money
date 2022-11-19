package br.com.fiap.fintech.monkeys_money.domain.usecase.iface.profile;

import br.com.fiap.fintech.monkeys_money.infradb.model.Profile;

public interface INewProfileUseCase {

    Profile save(Profile profile);
}
