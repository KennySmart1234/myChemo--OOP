package ng.myChemo.services;

import ng.myChemo.dtos.requests.*;
import ng.myChemo.dtos.responses.AddDrugResponse;
import ng.myChemo.dtos.responses.DeleteDrugResponse;
import ng.myChemo.dtos.responses.DispenseDrugsResponse;
import ng.myChemo.dtos.responses.UpdateDrugResponse;

public interface DrugInventoryServices {

    AddDrugResponse addDrug(AddDrugRequest request);
    UpdateDrugResponse updateDrug(UpdateDrugRequest request);
    DeleteDrugResponse deleteDrug(DeleteDrugRequest  request);
    DispenseDrugsResponse dispenseDrugs(DispenseDrugsRequest request);



}
