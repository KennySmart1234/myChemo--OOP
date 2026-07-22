package ng.myChemo.data.repositories;

import ng.myChemo.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepositoryImpl();
        userRepository.deleteAll();
    }

    @Test
    public void testThatNewRepositoryIsEmpty(){

        assertEquals(0, userRepository.count());
    }

    @Test
    public void testThatCountIsOneAfter_SavingFirstUser(){
        userRepository.save(new User());
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatCountIsThreeAfter_SavingThirdUser(){
        userRepository.save(new User());
        userRepository.save(new User());
        userRepository.save(new User());
        assertEquals(3, userRepository.count());
    }

    @Test
    public void testThatUserCanBeFindUserById(){
        User savedUser = userRepository.save(new User());
        User foundUser = userRepository.findById(savedUser.getId());
        assertEquals(savedUser, foundUser);
    }

    @Test
    public void testThatUnsavedUser_ReturnsNull(){
        User findUser = userRepository.findById(111);
        assertNull(findUser);
    }


    @Test
    public void testThatUserExistByID_ReturnsTrue(){
        User savedUser = userRepository.save(new User());
        boolean foundUser = userRepository.existsById(savedUser.getId());
        assertTrue(foundUser);
    }

    @Test
    public void testThatOneUserCanNotBeSavedTwice(){
        User user = new User();
        userRepository.save(user);
        assertThrows(IllegalArgumentException.class, () -> userRepository.save(user));
    }


    @Test
    public void testThatNoDuplicate_IdNumberAmongUser(){
        User savedUserOne = userRepository.save(new User());
        User savedUserTwo = userRepository.save(new User());
        assertNotEquals(savedUserOne.getId(), savedUserTwo.getId());

    }


    @Test
    public void testThatUserThatDoesNotExist_ReturnsFalse(){
        boolean foundUser = userRepository.existsById(77);
        assertFalse(foundUser);
    }

    @Test
    public void twoUsersSaved_TwoUserNoLongerExists_AfterDeletingByIdNumberTest(){
        User savedUserOne = userRepository.save(new User());
        User savedUserTwo = userRepository.save(new User());
        userRepository.deleteById(savedUserOne.getId());
        userRepository.deleteById(savedUserTwo.getId());
        assertFalse(userRepository.existsById(savedUserOne.getId()));
        assertFalse(userRepository.existsById(savedUserTwo.getId()));

        assertEquals(0, userRepository.count());
    }

    @Test
    public void testThatDeleteAllRemovesAllUsers(){
        User savedUserOne = userRepository.save(new User());
        User savedUserTwo = userRepository.save(new User());
        User savedUserThree = userRepository.save(new User());
        User savedUserFour = userRepository.save(new User());
        User savedUserFive =  userRepository.save(new User());
        userRepository.deleteAll();
        assertFalse(userRepository.existsById(savedUserOne.getId()));
        assertEquals(0, userRepository.count());

    }

    @Test
    public void testThatUserCanBeDeleted(){
        User savedUserOne = userRepository.save(new User());
        userRepository.delete(savedUserOne);
        assertFalse(userRepository.existsById(savedUserOne.getId()));
        assertEquals(0, userRepository.count());
    }

    @Test
    public void findUserByUsernameTest(){
        User savedUserOne = userRepository.save(new User());
        savedUserOne.setUsername("Kenny");

        User savedUserTwo = userRepository.save(new User());
        savedUserTwo.setUsername("Stephen");

        User foundUsername = userRepository.findByUsername("kenny");
        assertEquals(savedUserOne, foundUsername);

        User foundUsernameTwo = userRepository.findByUsername("stephen");
        assertEquals(savedUserTwo, foundUsernameTwo);


    }

}
