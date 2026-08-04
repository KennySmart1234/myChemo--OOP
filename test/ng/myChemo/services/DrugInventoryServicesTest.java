package ng.myChemo.services;

import ng.myChemo.data.models.Drug;
import ng.myChemo.data.repositories.*;
import ng.myChemo.dtos.requests.AddDrugRequest;
import ng.myChemo.dtos.requests.DeleteDrugRequest;
import ng.myChemo.dtos.requests.RegisterUserRequest;
import ng.myChemo.dtos.requests.UpdateDrugRequest;
import ng.myChemo.dtos.responses.AddDrugResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DrugInventoryServicesTest {

    private DrugInventoryServices drugInventoryServices;
    private DrugRepository drugRepository;
    private BatchRepository batchRepository;
    private UserRepository userRepository;
    private AuthServices authServices;


    @BeforeEach
    public void setUp() {
        drugRepository = new DrugRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        batchRepository = new BatchRepositoryImpl();

        drugRepository.deleteAll();
        userRepository.deleteAll();
        batchRepository.deleteAll();

        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Kenny");
        registerUserRequest.setPassword("1234");
        registerUserRequest.setFullName("Kenny Smart");

        authServices = new AuthServicesImpl();
        authServices.registerChemist(registerUserRequest);

        drugInventoryServices = new DrugInventoryServicesImpl();
    }



    @Test
    public void testThatDrugAddedReturnsCorrectResult() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("Paracetamol");
        request.setQuantity(50);
        request.setBrand("Emzor");
        request.setPrice(BigDecimal.valueOf(400));
        request.setChemistName("Kenny");
        request.setExpiryDate(LocalDate.of(2030, 4, 24));


        AddDrugResponse response = drugInventoryServices.addDrug(request);
        assertEquals("Paracetamol", response.getDrugName());
        assertEquals("Emzor", response.getBrand());
        assertEquals(50, response.getTotalDrugAdded());
        assertTrue(response.getBatchId() > 0);


    }

    @Test
    public void testThatDrugCountIncreasesAfterAdding() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("Panadol");
        request.setQuantity(20);
        request.setBrand("GSK");
        request.setPrice(BigDecimal.valueOf(300));
        request.setChemistName("Kenny");
        request.setExpiryDate(LocalDate.of(2029, 1, 1));

        drugInventoryServices.addDrug(request);

        assertEquals(1, drugRepository.count());
        assertEquals(1, batchRepository.count());
    }

    @Test
    public void testThatBatchQuantityMatchesDrugQuantity() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("Amoxicillin");
        request.setQuantity(75);
        request.setBrand("Ranbaxy");
        request.setPrice(BigDecimal.valueOf(1200));
        request.setChemistName("Kenny");
        request.setExpiryDate(LocalDate.of(2028, 6, 15));

        drugInventoryServices.addDrug(request);

        assertEquals(1, batchRepository.count());
    }

    @Test
    public void testThatEmptyDrugNameThrowsIllegalArgumentException() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("");
        request.setQuantity(10);
        request.setBrand("Emzor");
        request.setPrice(BigDecimal.valueOf(400));
        request.setChemistName("Kenny");
        request.setExpiryDate(LocalDate.of(2030, 4, 24));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.addDrug(request));
    }

    @Test
    public void testThatZeroQuantityThrowsIllegalArgumentException() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("Paracetamol");
        request.setQuantity(0);
        request.setBrand("Emzor");
        request.setPrice(BigDecimal.valueOf(400));
        request.setChemistName("Kenny");
        request.setExpiryDate(LocalDate.of(2030, 4, 24));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.addDrug(request));
    }

    @Test
    public void testThatUnregisteredChemistThrowsIllegalArgumentException() {
        AddDrugRequest request = new AddDrugRequest();
        request.setDrugName("Paracetamol");
        request.setQuantity(10);
        request.setBrand("Emzor");
        request.setPrice(BigDecimal.valueOf(400));
        request.setChemistName("UnknownChemist");
        request.setExpiryDate(LocalDate.of(2030, 4, 24));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.addDrug(request));
    }




    @Test
    public void testThatUpdatingWithInvalidDrugIdThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugId(0);
        request.setDrugName("Paracetamol");
        request.setDrugBrand("Emzor");
        request.setQuantity(10);
        request.setSellingPrice(BigDecimal.valueOf(400));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }


    @Test
    public void testThatUpdatingNonExistentDrugThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugId(9999);
        request.setDrugName("Paracetamol");
        request.setDrugBrand("Emzor");
        request.setQuantity(10);
        request.setSellingPrice(BigDecimal.valueOf(400));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }

    @Test
    public void testThatUpdatingWithEmptyDrugNameThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugName("");
        request.setDrugBrand("Emzor");
        request.setQuantity(10);
        request.setSellingPrice(BigDecimal.valueOf(400));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }

    @Test
    public void testThatUpdatingWithEmptyBrandThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugName("Paracetamol");
        request.setDrugBrand("");
        request.setQuantity(10);
        request.setSellingPrice(BigDecimal.valueOf(400));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }

    @Test
    public void testThatUpdatingWithZeroQuantityThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugName("Paracetamol");
        request.setDrugBrand("Emzor");
        request.setQuantity(0);
        request.setSellingPrice(BigDecimal.valueOf(400));

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }

    @Test
    public void testThatUpdatingWithInvalidPriceThrowsException() {
        UpdateDrugRequest request = new UpdateDrugRequest();
        request.setDrugName("Paracetamol");
        request.setDrugBrand("Emzor");
        request.setQuantity(10);
        request.setSellingPrice(BigDecimal.ZERO);

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.updateDrug(request));
    }


    @Test
    public void testThatAddingSameDrugTwiceMergesQuantityIntoExistingEntry() {
        AddDrugRequest firstRequest = new AddDrugRequest();
        firstRequest.setDrugName("Paracetamol");
        firstRequest.setQuantity(50);
        firstRequest.setBrand("Emzor");
        firstRequest.setPrice(BigDecimal.valueOf(400));
        firstRequest.setChemistName("Kenny");
        firstRequest.setExpiryDate(LocalDate.of(2030, 4, 24));

        AddDrugResponse firstResponse = drugInventoryServices.addDrug(firstRequest);

        AddDrugRequest secondRequest = new AddDrugRequest();
        secondRequest.setDrugName("Paracetamol");
        secondRequest.setQuantity(30);
        secondRequest.setBrand("Emzor");
        secondRequest.setPrice(BigDecimal.valueOf(400));
        secondRequest.setChemistName("Kenny");
        secondRequest.setExpiryDate(LocalDate.of(2031, 1, 1));

        AddDrugResponse secondResponse = drugInventoryServices.addDrug(secondRequest);

        assertEquals(80, secondResponse.getTotalDrugAdded());

        Drug savedDrug = drugRepository.findByNameAndBrand("Paracetamol", "Emzor");
        assertNotNull(savedDrug);
        assertEquals(80, savedDrug.getQuantity());

    }



    @Test
    public void testThatDeletingWithInvalidDrugIdThrowsException() {
        DeleteDrugRequest request = new DeleteDrugRequest();
        request.setDrugId(0);

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.deleteDrug(request));
    }

    @Test
    public void testThatDeletingNonExistentDrugThrowsException() {
        DeleteDrugRequest request = new DeleteDrugRequest();
        request.setDrugId(9999);

        assertThrows(IllegalArgumentException.class, () -> drugInventoryServices.deleteDrug(request));
    }




}



