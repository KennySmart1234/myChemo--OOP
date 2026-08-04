package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DrugRepositoryTest {

    private DrugRepository drugRepository;

    @BeforeEach
    public void setUp() {

        drugRepository = new DrugRepositoryImpl();
    }

    @Test
    public void testThatNewRepositoryIsEmpty(){
        assertEquals(0, drugRepository.count());
    }

    @Test
    public void testThatCountIsOneAfter_SavingFirstDrug(){
        drugRepository.save(new Drug());
        assertEquals(1, drugRepository.count());
    }

    @Test
    public void testThatCountIsThreeAfter_SavingThirdDrug(){
        drugRepository.save(new Drug());
        drugRepository.save(new Drug());
        drugRepository.save(new Drug());
        assertEquals(3, drugRepository.count());
    }

    @Test
    public void testThatDrugCanFindById(){
        Drug savedDrug = drugRepository.save(new Drug());
        Drug foundDrug = drugRepository.findById(savedDrug.getDrugId());
        assertEquals(savedDrug, foundDrug);
    }

    @Test
    public void testThatDrugAttributeReturns_correctIdNumber(){
        Drug drug = new Drug();
        drug.setDrugName("Paracetamol");
        drug.setBrand("Care");
        drug.setSellingPrice(BigDecimal.valueOf(490));

        Drug savedDrug = drugRepository.save(drug);
        Drug foundDrug = drugRepository.findById(drug.getDrugId());

        assertEquals(savedDrug, foundDrug);
        assertEquals(1, drugRepository.count());
    }

    @Test
    public void testThatUnsavedDrug_ReturnsNull(){
        Drug findUser = drugRepository.findById(34);
        assertNull(findUser);
    }

    @Test
    public void threeDrugsSaved_oneDrugDeleted_countIsTwoTest(){
        Drug drugOne = new Drug();
        drugOne.setDrugName("Panadol");
        drugOne.setBrand("SSS");
        drugOne.setSellingPrice(BigDecimal.valueOf(700));
        drugRepository.save(drugOne);
        drugRepository.delete(drugOne);


        Drug drugTwo = new Drug();
        drugTwo.setDrugName("Alabunkun");
        drugTwo.setBrand("Semicolon");
        drugTwo.setSellingPrice(BigDecimal.valueOf(400));
        drugRepository.save(drugTwo);

        Drug drugThree = new Drug();
        drugThree.setDrugName("Black drug");
        drugThree.setBrand("Village");
        drugThree.setSellingPrice(BigDecimal.valueOf(500));
        Drug savedDrugThree =  drugRepository.save(drugThree);

        Drug foundDrug = drugRepository.findById(drugThree.getDrugId());
        assertEquals(savedDrugThree, foundDrug );
        assertEquals(2, drugRepository.count());


    }

    @Test
    public void testThatDrugCanbeDeletedById(){
        Drug drugOne = new Drug();
        drugOne.setDrugName("Panadol");
        drugOne.setBrand("MMM");
        drugOne.setSellingPrice(BigDecimal.valueOf(900));
        drugRepository.save(drugOne);
        drugRepository.deleteById(drugOne.getDrugId());


        Drug drugTwo = new Drug();
        drugTwo.setDrugName("Alabunkun");
        drugTwo.setBrand("Semicolon");
        drugTwo.setSellingPrice(BigDecimal.valueOf(200));
        drugRepository.save(drugTwo);
        drugRepository.deleteById(drugTwo.getDrugId());

        assertEquals(0, drugRepository.count());
    }

    @Test
    public void testThatAllDrugsCanBeDeletedAtOnce() {
        Drug drugOne = new Drug();
        drugOne.setDrugName("Biko");
        drugOne.setBrand("MMM");
        drugOne.setSellingPrice(BigDecimal.valueOf(400));
        drugRepository.save(drugOne);


        Drug drugTwo = new Drug();
        drugTwo.setDrugName("Alabunkun");
        drugTwo.setBrand("9gia");
        drugTwo.setSellingPrice(BigDecimal.valueOf(500));
        drugRepository.save(drugTwo);


        Drug drugThree = new Drug();
        drugThree.setDrugName("Panadol");
        drugThree.setBrand("WWW");
        drugThree.setSellingPrice(BigDecimal.valueOf(100));
        drugRepository.save(drugThree);

        assertEquals(3, drugRepository.count());
        drugRepository.deleteAll();
        assertEquals(0, drugRepository.count());

    }

//    @Test
//    public void testThatDrugExistsById_returnsTrue(){
//        Drug drugOne = new Drug();
//        drugOne.setDrugName("Biko");
//        drugOne.setBrand("MMM");
//        drugOne.setSellingPrice(500);
//        Drug savedrug = drugRepository.save(drugOne);
//        assertTrue(drugRepository.existsById(savedrug.getDrugId()));
//    }

}