package br.com.fiap.fintech.monkeys_money.domain.usecase;

import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user.INewUserUseCase;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;
import br.com.fiap.fintech.monkeys_money.infradb.repository.UserRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class NewUserUseCase implements INewUserUseCase {

    private final UserRepository repository;

    public NewUserUseCase(){
        repository = new UserRepository();
    }

    @Override
    public User of(User user) {

        user.setEnabled(true);
        user.setCreateAt(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));

        try {
            user = repository.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
