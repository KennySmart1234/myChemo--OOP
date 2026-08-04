package ng.myChemo.data.repositories;

import ng.myChemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final List<User> users = new ArrayList<>();
    private static long userId = 0;



    @Override
    public long count() {

        return users.size();
    }


    @Override
    public User save(User user) {
        if (isNew(user)) {
            saveNew(user);
        }else {
            updateExisting(user);
        }
        return user;
    }


    private boolean isNew(User user){

        return user.getUserId() == 0;
    }


    private void saveNew(User user){
        if (users.contains(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        user.setUserId(++userId);
        users.add(user);

    }

    @Override
    public void deleteById(long userId) {
        User user = findById(userId);
        if (user != null) {
            users.remove(user);
        }
    }


    @Override
    public void delete(User user) {
        users.remove(user);
    }


    private void updateExisting(User user){
        User existingUser = findById(user.getUserId());
        if (existingUser != null) {
            throw new IllegalArgumentException("User already exists");
        }

        int index = users.indexOf(existingUser);
        users.set(index, user);

    }



    @Override
    public void deleteAll(){
        users.clear();
        userId = 0;
    }


    @Override
    public User findById(long userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        users.clear();
    }

    @Override
    public boolean existsById(long userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }
}
