package ng.myChemo.data.repositories;

import ng.myChemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();
    private int count;

    @Override
    public int count() {
        return count;
    }


    @Override
    public User save(User user) {
        if (!users.contains(user)) {
            user.setId(++count);
            users.add(user);
            return user;
        }
        throw new IllegalArgumentException("user already exists");

    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void delete(User user) {
        users.remove(user);
        count--;
    }

    @Override
    public void deleteById(int id) {
        users.remove(findById(id));
        count--;
    }

    @Override
    public void deleteAll(){
        users.clear();
        count = 0;
    }

    @Override
    public boolean existsById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;    }

}
