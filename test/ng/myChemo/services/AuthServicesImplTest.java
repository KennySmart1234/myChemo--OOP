package ng.myChemo.services;

import ng.myChemo.dtos.requests.LoginRequest;
import ng.myChemo.dtos.requests.LogoutRequest;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.responses.LoginResponse;
import ng.myChemo.dtos.responses.LogoutResponse;
import ng.myChemo.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServicesImplTest {

    private AuthServicesImpl authServices;
    @BeforeEach
    public void setUp() {

        authServices = new AuthServicesImpl();
    }

    @Test
    public void testThatAfterRegisteringChemistSuccessfully_returnsCorrectUsernameAndFullName(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Olatunji");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Kenny");

        RegisterUserResponse registerUserResponse = authServices.registerChemist(registerUserRequest);
        assertEquals("olatunji", registerUserResponse.getUsername().toLowerCase());
        assertEquals("Kenny", registerUserResponse.getFullName());

    }


    @Test
    public void testThatTwoChemistRegisterSuccessfully_ReturnsCorrectUsernameAndFullName(){
        RegisterUserRequest registerUserRequestOne = new RegisterUserRequest();
        registerUserRequestOne.setUsername("Olatunji");
        registerUserRequestOne.setPassword("1234");
        registerUserRequestOne.setFullName("Kenny");
        RegisterUserResponse registerUserResponseOne = authServices.registerChemist(registerUserRequestOne);
        assertEquals("olatunji", registerUserResponseOne.getUsername().toLowerCase());
        assertEquals("Kenny", registerUserResponseOne.getFullName());


        RegisterUserRequest registerUserRequestTwo = new RegisterUserRequest();
        registerUserRequestTwo.setUsername("stephen");
        registerUserRequestTwo.setPassword("1234");
        registerUserRequestTwo.setFullName("Smart");
        RegisterUserResponse registerUserResponse = authServices.registerChemist(registerUserRequestTwo);
        assertEquals("stephen", registerUserResponse.getUsername().toLowerCase());
        assertEquals("Smart", registerUserResponse.getFullName());

    }


    @Test
    public void testThatDuplicateUsernameRegistration_ThrowsIllegalArgumentException(){
        RegisterUserRequest registerUserRequestOne = new RegisterUserRequest();
        registerUserRequestOne.setUsername("stephen");
        registerUserRequestOne.setPassword("1234");
        registerUserRequestOne.setFullName("Smart");
       authServices.registerChemist(registerUserRequestOne);


        RegisterUserRequest registerUserRequestTwo = new RegisterUserRequest();
        registerUserRequestTwo.setUsername("stephen");
        registerUserRequestTwo.setPassword("1234");
        registerUserRequestTwo.setFullName("Smart");
        assertThrows(IllegalArgumentException.class, ()->authServices.registerChemist(registerUserRequestTwo));

    }


    @Test
    public void loginChemist_SuccessfullyLoginTest(){
        AuthServicesImpl authServices = new AuthServicesImpl();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUsername("Stephen");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Smart");

        authServices.registerChemist(registerUserRequest);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("stephen");
        loginRequest.setPassword("1234");

        LoginResponse loginResponse = authServices.login(loginRequest);
        assertTrue(loginResponse.isLoggedIn());

    }


    @Test
    public void testThatInvalidUsername_ThrowsIllegalArgumentException(){
        AuthServicesImpl authServices = new AuthServicesImpl();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUsername("Stephen");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Smart");

        authServices.registerChemist(registerUserRequest);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("JJJJJJ");
        loginRequest.setPassword("1234");

        assertThrows(IllegalArgumentException.class, ()->authServices.login(loginRequest));

    }


    @Test
    public void testThatInvalidPassword_ThrowsIllegalArgumentException(){
        AuthServicesImpl authServices = new AuthServicesImpl();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUsername("Stephen");
        registerUserRequest.setPassword("abcdefgh");
        registerUserRequest.setFullName("Smart");

        authServices.registerChemist(registerUserRequest);

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setUsername("Stephen");
        loginRequest.setPassword("ABCDEFGH");
        assertThrows(IllegalArgumentException.class, ()->authServices.login(loginRequest));

    }


    @Test
    public void testThatLogoutIsTrue_afterLoggingIn(){
        AuthServicesImpl authServices = new AuthServicesImpl();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUsername("Stephen");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Smart");
        authServices.registerChemist(registerUserRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Stephen");
        loginRequest.setPassword("1234");

        authServices.login(loginRequest);

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("Stephen");
        LogoutResponse logoutResponse = authServices.logout(logoutRequest);
        assertFalse(logoutResponse.isLoggedIn());

    }


    @Test
    public void testThatIncorrectUsernameThrowsIllegalArgumentException(){
        AuthServicesImpl authServices = new AuthServicesImpl();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();

        registerUserRequest.setUsername("Stephen");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Smart");
        authServices.registerChemist(registerUserRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Stephen");
        loginRequest.setPassword("1234");

        authServices.login(loginRequest);

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setUsername("JJJJJJJJJJ");
        assertThrows(IllegalArgumentException.class, ()->authServices.logout(logoutRequest));


    }

}
