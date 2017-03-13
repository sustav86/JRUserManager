package com.sustav86.usersmanager.dao;

import com.sustav86.usersmanager.sample.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SUSTAVOV on 12.03.2017.
 */
@Repository
public class UserDaoImp implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info(user + " successfully added");
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info(user + " successfully update");

    }

    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        if (user != null) {
            session.delete(user);
        }
        logger.info(user + " successfully delete");
    }

    @SuppressWarnings("unchecked")
    public List<User> searchUser(String name) {
        Session session = this.sessionFactory.getCurrentSession();

        String hql = "from User U WHERE U.userName LIKE :employee_name";
        Query query = session.createQuery(hql);
        query.setParameter("employee_name", name);
        List<User> userList = query.list();
        for (User user : userList) {
            logger.info("Users list" + user);
        }

        return userList;
    }

    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info(user + " successfully loaded");

        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User user : userList) {
            logger.info("Users list" + user);
        }

        return userList;
    }
}
