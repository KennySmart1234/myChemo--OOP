package ng.myChemo.data.repositories;

import ng.myChemo.data.models.User;

public interface UserRepository {

    long count();

    User save(User user);

    User findById(long userId);

    void deleteById(long userId);

    void delete(User user);

    void deleteAll();

//    boolean existsById(i id);

    User findByUsername(String username);
    void clear();
    boolean existsById(long userId);

}
