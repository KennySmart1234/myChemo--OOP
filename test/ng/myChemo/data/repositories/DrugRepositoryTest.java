package ng.myChemo.data.repositories;

import ng.myChemo.data.models.Drug;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        Drug foundDrug = drugRepository.findById(savedDrug.getId());
        assertEquals(savedDrug, foundDrug);
    }

    @Test
    public void testThatDrugAttributeReturns_correctIdNumber(){
        Drug drug = new Drug();
        drug.setName("Paracetamol");
        drug.setBrand("Nigeria");
        drug.setPrice(200);
        drug.setExpiryDate(LocalDate.of(2030,5,30));

        Drug savedDrug = drugRepository.save(drug);
        Drug foundDrug = drugRepository.findById(drug.getId());

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
        drugOne.setName("Panadol");
        drugOne.setBrand("SSS");
        drugOne.setPrice(500);
        drugOne.setExpiryDate(LocalDate.of(2030,5,30));
        drugRepository.save(drugOne);
        drugRepository.delete(drugOne);


        Drug drugTwo = new Drug();
        drugTwo.setName("Alabunkun");
        drugTwo.setBrand("Semicolon");
        drugTwo.setPrice(2);
        drugTwo.setExpiryDate(LocalDate.of(2035,10,6));
        drugRepository.save(drugTwo);

        Drug drugThree = new Drug();
        drugThree.setName("Black drug");
        drugThree.setBrand("Village");
        drugThree.setPrice(2);
        drugThree.setExpiryDate(LocalDate.of(2038,10,6));
        Drug savedDrugThree =  drugRepository.save(drugThree);

        Drug foundDrug = drugRepository.findById(drugThree.getId());
        assertEquals(savedDrugThree, foundDrug );
        assertEquals(2, drugRepository.count());


    }

    @Test
    public void testThatDrugCanbeDeletedById(){
        Drug drugOne = new Drug();
        drugOne.setName("Panadol");
        drugOne.setBrand("MMM");
        drugOne.setPrice(500);
        drugOne.setExpiryDate(LocalDate.of(2030,5,30));
        drugRepository.save(drugOne);
        drugRepository.deleteById(drugOne.getId());


        Drug drugTwo = new Drug();
        drugTwo.setName("Alabunkun");
        drugTwo.setBrand("Semicolon");
        drugTwo.setPrice(2);
        drugTwo.setExpiryDate(LocalDate.of(2035,10,6));
        drugRepository.save(drugTwo);
        drugRepository.deleteById(drugTwo.getId());

        assertEquals(0, drugRepository.count());
    }

    @Test
    public void testThatAllDrugsCanBeDeletedAtOnce() {
        Drug drugOne = new Drug();
        drugOne.setName("Biko");
        drugOne.setBrand("MMM");
        drugOne.setPrice(500);
        drugOne.setExpiryDate(LocalDate.of(2030, 5, 30));
        drugRepository.save(drugOne);


        Drug drugTwo = new Drug();
        drugTwo.setName("Alabunkun");
        drugTwo.setBrand("9gia");
        drugTwo.setPrice(2);
        drugTwo.setExpiryDate(LocalDate.of(2035, 10, 6));
        drugRepository.save(drugTwo);


        Drug drugThree = new Drug();
        drugThree.setName("Panadol");
        drugThree.setBrand("WWW");
        drugThree.setPrice(100);
        drugThree.setExpiryDate(LocalDate.of(2030, 5, 30));
        drugRepository.save(drugThree);

        assertEquals(3, drugRepository.count());
        drugRepository.deleteAll();
        assertEquals(0, drugRepository.count());

    }

    @Test
    public void testThatDrugExistsById_returnsTrue(){
        Drug drugOne = new Drug();
        drugOne.setName("Biko");
        drugOne.setBrand("MMM");
        drugOne.setPrice(500);
        drugOne.setExpiryDate(LocalDate.of(2030, 5, 30));
        Drug savedrug = drugRepository.save(drugOne);
        assertTrue(drugRepository.existsById(savedrug.getId()));
    }

}