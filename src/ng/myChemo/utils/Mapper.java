package ng.myChemo.utils;

import ng.myChemo.data.models.Batch;
import ng.myChemo.data.models.Drug;
import ng.myChemo.data.models.User;
import ng.myChemo.dtos.requests.AddDrugRequest;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.requests.UpdateDrugRequest;
import ng.myChemo.dtos.responses.*;

import java.time.LocalDate;
import java.time.YearMonth;

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


    public static Drug mapToDrugRequest(AddDrugRequest request) {
        Drug drug = new Drug();
        drug.setBrand(request.getBrand());
        drug.setDrugName(request.getDrugName());
        drug.setSellingPrice(request.getPrice());
        drug.setQuantity(request.getQuantity());

        return drug;

    }

    public static AddDrugResponse mapToAddDrugResponse(Drug drug, Batch batch) {
        AddDrugResponse response = new AddDrugResponse();
        response.setDrugName(drug.getDrugName());
        response.setBrand(drug.getBrand());
        response.setTotalDrugAdded(drug.getQuantity());
        response.setBatchId(batch.getBatchId());

        return response;

    }


    public static  Batch mapToBatchRequest(AddDrugRequest request) {
        Batch batch = new Batch();
        batch.setPurchaseQuantity(request.getQuantity());
        batch.setQuantityLeft(request.getQuantity());
        batch.setExpiryDate(YearMonth.from(request.getExpiryDate()));
        batch.setCostPrice(request.getPrice());
        batch.setPurchaseDate(LocalDate.now());

        return batch;
    }


    public static Drug mapToDrugRequest(UpdateDrugRequest request, Drug drug) {
        drug.setDrugName(request.getDrugName());
        drug.setBrand(request.getDrugBrand());
        drug.setQuantity(request.getQuantity());
        drug.setSellingPrice(request.getSellingPrice());

        return drug;
    }


    public static UpdateDrugResponse mapToUpdateDrugResponse(Drug drug) {
        UpdateDrugResponse response = new UpdateDrugResponse();
        response.setDrugID(drug.getDrugId());
        response.setDrugName(drug.getDrugName());
        response.setDrugBrand(drug.getBrand());
        response.setSellingPrice(drug.getSellingPrice());
        response.setQuantity(drug.getQuantity());
        response.setMessage("Drug updated successfully");

        return response;
    }


    public static DeleteDrugResponse mapToDeleteDrugResponse(Drug drug) {
        DeleteDrugResponse response = new DeleteDrugResponse();
        response.setDrugId(drug.getDrugId());
        response.setDrugName(drug.getDrugName());
        response.setBrand(drug.getBrand());

        return response;
    }


}
