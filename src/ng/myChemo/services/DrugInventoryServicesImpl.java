package ng.myChemo.services;

import ng.myChemo.data.models.Batch;
import ng.myChemo.data.models.Drug;
import ng.myChemo.data.models.User;
import ng.myChemo.data.repositories.*;
import ng.myChemo.dtos.requests.*;
import ng.myChemo.dtos.responses.AddDrugResponse;
import ng.myChemo.dtos.responses.DeleteDrugResponse;
import ng.myChemo.dtos.responses.DispenseDrugsResponse;
import ng.myChemo.dtos.responses.UpdateDrugResponse;
import ng.myChemo.utils.Mapper;

import java.math.BigDecimal;

public class DrugInventoryServicesImpl implements DrugInventoryServices {
    private BatchRepository batchRepository = new BatchRepositoryImpl();
    private UserRepository userRepository = new UserRepositoryImpl();
    private DrugRepository drugRepository = new DrugRepositoryImpl();


    @Override
    public AddDrugResponse addDrug(AddDrugRequest request) {


        boolean isInvalidName = request.getDrugName() == null || request.getDrugName().isBlank();
        if (isInvalidName) {
            throw new IllegalArgumentException("Drug name cannot be empty");
        }
        boolean isInvalidBrand = request.getBrand() == null || request.getBrand().isBlank();
        if (isInvalidBrand) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        boolean isInvalidChemistName = request.getChemistName() == null || request.getChemistName().isBlank();
        if (isInvalidChemistName) {
            throw new IllegalArgumentException("Chemist name cannot be empty");
        }
        boolean isInvalidQuantity = request.getQuantity() <= 0;
        if (isInvalidQuantity) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        boolean isInvalidCost = request.getPrice() == null || request.getPrice().compareTo(BigDecimal.ZERO) <= 0;
        if (isInvalidCost) {
            throw new IllegalArgumentException("Cost must be greater than zero");
        }
        boolean isInvalidExpiryDate = request.getExpiryDate() == null;
        if (isInvalidExpiryDate) {
            throw new IllegalArgumentException("Expiry date cannot be null");
        }
        User user = userRepository.findByUsername(request.getChemistName().toLowerCase()
        );

        if (user == null) {
            throw new IllegalArgumentException("Chemist does not exist");
        }

        Batch batch = Mapper.mapToBatchRequest(request);

        Drug existingDrug = drugRepository.findByNameAndBrand(request.getDrugName(), request.getBrand());

        Drug drug;
        if (existingDrug != null) {
            drug = existingDrug;
            drug.setQuantity(drug.getQuantity() + request.getQuantity());

        } else {

            drug = Mapper.mapToDrugRequest(request);
            drug.setQuantity(request.getQuantity());
        }
            drug.getBatches().add(batch);


            drugRepository.save(drug);

            batch.setDrugId(drug.getDrugId());
            batchRepository.save(batch);

            AddDrugResponse response = Mapper.mapToAddDrugResponse(drug, batch);

            return response;

    }



    @Override
    public UpdateDrugResponse updateDrug(UpdateDrugRequest request) {

        boolean isInvalidDrugId = request.getDrugId() <= 0;
        if (isInvalidDrugId) {
            throw new IllegalArgumentException("Drug id must be greater than zero");
        }

        Drug drug = drugRepository.findById(request.getDrugId());
        if (drug == null) {
            throw new IllegalArgumentException("Drug does not exist");
        }

        boolean isInvalidName = request.getDrugName() == null || request.getDrugName().isBlank();
        if (isInvalidName) {
            throw new IllegalArgumentException("Drug name cannot be empty");
        }

        boolean isInvalidBrand = request.getDrugBrand() == null || request.getDrugBrand().isBlank();
        if (isInvalidBrand) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }

        boolean isInvalidQuantity = request.getQuantity() <= 0;
        if (isInvalidQuantity) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        boolean isInvalidPrice = request.getSellingPrice() == null || request.getSellingPrice().compareTo(BigDecimal.ZERO) <= 0;
        if (isInvalidPrice) {
            throw new IllegalArgumentException("Selling price must be greater than zero");
        }

        Mapper.mapToDrugRequest(request, drug);
        drugRepository.save(drug);
        return Mapper.mapToUpdateDrugResponse(drug);
    }


    @Override
    public DeleteDrugResponse deleteDrug(DeleteDrugRequest request){

        boolean isInvalidDrugId = request.getDrugId() <= 0;
        if (isInvalidDrugId) {
            throw new IllegalArgumentException("Drug id must be greater than zero");
        }

        Drug drug = drugRepository.findById(request.getDrugId());
        if (drug == null) {
            throw new IllegalArgumentException("Drug does not exist");
        }

        DeleteDrugResponse response = Mapper.mapToDeleteDrugResponse(drug);

        drugRepository.delete(drug);

        return response;
    }

    @Override
    public DispenseDrugsResponse dispenseDrugs(DispenseDrugsRequest request){
        return null;
    }


}
