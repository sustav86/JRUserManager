package com.sustav86.usersmanager.maintain;

import com.sustav86.usersmanager.dao.UserDao;
import com.sustav86.usersmanager.sample.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SUSTAVOV on 12.03.2017.
 */
@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);

    }

    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);

    }

    @Transactional
    public void deleteUser(int id) {
        this.userDao.deleteUser(id);

    }

    @Transactional
    public List<User> searchUser(String name) {
        return this.userDao.searchUser(name);
    }


    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
