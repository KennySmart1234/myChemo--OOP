package ng.myChemo.data.repositories;

import ng.myChemo.data.models.DispensedDrugs;
import ng.myChemo.data.models.Drug;
import ng.myChemo.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class DispensedDrugRepositoryTest {

    private DispensedDrugsRepository dispensedDrugsRepository;
    @BeforeEach
    public void setup() {
        dispensedDrugsRepository = new DispensedDrugsRepositoryImpl();
    }

    @Test
    public void testThatNewRepositoryIsEmpty(){
        assertEquals(0, dispensedDrugsRepository.count());
    }

    @Test
    public void testThatCountIsOneAfter_SavingFirstDispensedDrugs(){
        dispensedDrugsRepository.save(new DispensedDrugs());
        assertEquals(1, dispensedDrugsRepository.count());
    }

    @Test
    public void testThatCountIsThreeAfter_SavingThirdDispensedDrugs(){
        DispensedDrugs  dispensedDrugs = new DispensedDrugs();
        dispensedDrugsRepository.save(new DispensedDrugs());
        dispensedDrugsRepository.save(new DispensedDrugs());
        dispensedDrugsRepository.save(new DispensedDrugs());
        assertEquals(3, dispensedDrugsRepository.count());
    }

    @Test
    public void testThatDispensedDrugsCanBeFindById(){
        DispensedDrugs  dispensedDrugs = new DispensedDrugs();
        DispensedDrugs savedDispensedDrugs = dispensedDrugsRepository.save(dispensedDrugs);
        assertEquals(savedDispensedDrugs, dispensedDrugsRepository.findById(dispensedDrugs.getId()));

    }


    @Test
    public void testThatDispensedDrugCanNotBeSavedTwice(){
        DispensedDrugs  dispensedDrugs = new DispensedDrugs();
        DispensedDrugs savedDispensedDrugs = dispensedDrugsRepository.save(dispensedDrugs);
        assertEquals(savedDispensedDrugs, dispensedDrugsRepository.findById(dispensedDrugs.getId()));
        assertThrows(IllegalArgumentException.class, () -> dispensedDrugsRepository.save(dispensedDrugs));

    }


    @Test
    public void testThatDispensedByCanBeSetAndRetrieved(){
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setDispensedDate(LocalDateTime.now());
        User user = new User();
        user.setUsername("Stephen");
        dispensedDrugs.setDispensedBy(user);
        DispensedDrugs savedDispensedDrugs = dispensedDrugsRepository.save(dispensedDrugs);
        assertEquals(1, dispensedDrugsRepository.count());
        DispensedDrugs foundDispensedDrugs =  dispensedDrugsRepository.findById(dispensedDrugs.getId());
        assertEquals(savedDispensedDrugs, foundDispensedDrugs);

    }


    @Test
    public void testThatDispensedDrugsCanBeDeletedById(){
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setDispensedDate(LocalDateTime.now());
        User user = new User();
        user.setUsername("Stephen");
        dispensedDrugs.setDispensedBy(user);
        DispensedDrugs DispensedDrugs = dispensedDrugsRepository.save(dispensedDrugs);
        assertEquals(1, dispensedDrugsRepository.count());
        dispensedDrugsRepository.deleteById(DispensedDrugs.getId());
        assertEquals(0, dispensedDrugsRepository.count());

    }

    @Test
    public void oneDispensedDrugCreated_deleteOne_DrugRepositoryIsEmptyTest(){
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setDispensedDate(LocalDateTime.now());
        User user = new User();
        user.setUsername("Stephen");
        dispensedDrugs.setDispensedBy(user);
        DispensedDrugs DispensedDrugs = dispensedDrugsRepository.save(dispensedDrugs);
        assertEquals(1, dispensedDrugsRepository.count());
        dispensedDrugsRepository.delete(DispensedDrugs);
        assertEquals(0, dispensedDrugsRepository.count());

    }

    @Test
    public void threeDispensedDrugsCreated_deleteThree_DispensedDrugsRepositoryIsEmptyTest(){
        DispensedDrugs dispensedDrugsOne = new DispensedDrugs();
        dispensedDrugsOne.setDispensedDate(LocalDateTime.now());
        User user = new User();
        user.setUsername("Stephen");
        dispensedDrugsOne.setDispensedBy(user);
        dispensedDrugsRepository.save(dispensedDrugsOne);


        DispensedDrugs dispensedDrugsTwo = new DispensedDrugs();
        dispensedDrugsTwo.setDispensedDate(LocalDateTime.now());
        User userTwo = new User();
        user.setUsername("Kenny");
        dispensedDrugsTwo.setDispensedBy(user);
        dispensedDrugsRepository.save(dispensedDrugsTwo);
        assertEquals(2, dispensedDrugsRepository.count());
        dispensedDrugsRepository.deleteAll();
        assertEquals(0, dispensedDrugsRepository.count());
    }

    @Test
    public void testThatDispensedDrugsExistsById_returnsTrue(){
        DispensedDrugs dispensedDrugs = new DispensedDrugs();
        dispensedDrugs.setDispensedDate(LocalDateTime.now());
        User user = new User();
        user.setUsername("Stephen");
        dispensedDrugs.setDispensedBy(user);
        dispensedDrugsRepository.save(dispensedDrugs);
        assertTrue(dispensedDrugsRepository.existsById(dispensedDrugs.getId()));
    }

}
