package br.com.fiap.fintech.monkeys_money.cross.mapper;

import br.com.fiap.fintech.monkeys_money.app.dto.request.UserRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.infradb.model.User;

import java.util.Objects;

public class UserMapper {

    public static UserResponse dbToResponse(final User user){
        Objects.nonNull(user);

        var response = new UserResponse();

        response.setEmail(user.getEmail());
        response.setEnabled(user.getEnabled());
        response.setCreateAt(user.getCreateAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }

    public static User requestToDB(final UserRequest request){
        Objects.nonNull(request);

        var user = new User();

        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }

}
