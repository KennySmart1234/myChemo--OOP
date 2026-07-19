package ng.myChemo.data.repositories;

import ng.myChemo.data.models.User;

public interface UserRepository {

    int count();

    User save(User user);

    User findById(int id);

    void deleteById(int id);

    void delete(User user);

    void deleteAll();

    boolean existsById(int id);

    User findByUsername(String username);

}
