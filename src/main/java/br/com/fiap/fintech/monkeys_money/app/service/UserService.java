package br.com.fiap.fintech.monkeys_money.app.service;

import java.util.Map;

import br.com.fiap.fintech.monkeys_money.app.dto.request.UserRequest;
import br.com.fiap.fintech.monkeys_money.app.dto.response.UserResponse;
import br.com.fiap.fintech.monkeys_money.app.service.iface.IUserService;
import br.com.fiap.fintech.monkeys_money.cross.mapper.UserMapper;
import br.com.fiap.fintech.monkeys_money.domain.usecase.FindUserUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.NewUserUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user.IFindUserUseCase;
import br.com.fiap.fintech.monkeys_money.domain.usecase.iface.user.INewUserUseCase;

public class UserService implements IUserService<UserResponse, UserRequest> {

    private INewUserUseCase newUseCase;
    private IFindUserUseCase findUseCase;

    public UserService(){
    	newUseCase = new NewUserUseCase();
    	findUseCase = new FindUserUseCase();
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        // convert to object db
        var user = UserMapper.requestToDB(userRequest);

        // save and return object request
        return UserMapper.dbToResponse(newUseCase.of(user));
    }

    @Override
    public UserResponse findOne(Map<String, Object> params) {
        return UserMapper.dbToResponse(findUseCase.of(params));
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
