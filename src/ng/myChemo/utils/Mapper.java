package ng.myChemo.utils;

import ng.myChemo.data.models.User;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.responses.LoginResponse;
import ng.myChemo.dtos.responses.LogoutResponse;
import ng.myChemo.dtos.responses.RegisterUserResponse;

public class Mapper {


    public static User mapToUserRequest(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        user.setFullName(registerUserRequest.getFullName());
        return user;
    }

    public static RegisterUserResponse mapToUserResponse(User user) {
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(user.getUsername());
        registerUserResponse.setFullName(user.getFullName());
        return  registerUserResponse;
    }



    public static LoginResponse mapToLoginResponse(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());

        loginResponse.setLoggedIn(true);
        return  loginResponse;
    }


    public static LogoutResponse mapToLogoutResponse(User user) {
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setLoggedIn(false);
        return  logoutResponse;
    }


}
