package ng.myChemo.services;

import ng.myChemo.dtos.requests.LoginRequest;
import ng.myChemo.dtos.requests.LogoutRequest;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.responses.LoginResponse;
import ng.myChemo.dtos.responses.LogoutResponse;
import ng.myChemo.dtos.responses.RegisterUserResponse;

public interface AuthServices {

    RegisterUserResponse registerChemist(RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginRequest  loginRequest);
    LogoutResponse logout(LogoutRequest logoutRequest);

}
