package com.sustav86.usersmanager.maintain;

import com.sustav86.usersmanager.sample.User;

import java.util.List;

/**
 * Created by SUSTAVOV on 12.03.2017.
 */
public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> searchUser(String name);

    User getUserById(int id);

    List<User> listUsers();
}
