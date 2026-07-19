package ng.myChemo.services;

import ng.myChemo.data.models.User;
import ng.myChemo.data.repositories.UserRepository;
import ng.myChemo.data.repositories.UserRepositoryImpl;
import ng.myChemo.dtos.requests.LoginRequest;
import ng.myChemo.dtos.requests.LogoutRequest;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.responses.LoginResponse;
import ng.myChemo.dtos.responses.LogoutResponse;
import ng.myChemo.dtos.responses.RegisterUserResponse;

import static ng.myChemo.utils.Mapper.*;

public class AuthServicesImpl implements AuthServices {

    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public RegisterUserResponse registerChemist(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setUsername(registerUserRequest.getUsername().toLowerCase());
        if (userRepository.findByUsername(registerUserRequest.getUsername()) != null)
            throw new IllegalArgumentException("Username already exists");

        User user = mapToUserRequest(registerUserRequest);
        userRepository.save(user);
        return mapToUserResponse(user);

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {

            return mapToLoginResponse(user);

        }
        throw new IllegalArgumentException("Invalid username or password");
    }


        @Override
    public LogoutResponse logout(LogoutRequest logoutRequest) {
        User user = userRepository.findByUsername(logoutRequest.getUsername());
        if (user != null) {
           return mapToLogoutResponse(user);
        }

        throw new IllegalArgumentException("Invalid username or password");
    }
}