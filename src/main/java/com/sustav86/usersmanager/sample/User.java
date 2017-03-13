package com.sustav86.usersmanager.sample;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by SUSTAVOV on 12.03.2017.
 */
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "IS_ADMIN")
    private boolean admin;

    @Column(name = "CREATED_DATE")
    private Timestamp createdDate;

    public User() {
        Date currentDate = new Date();
        this.createdDate = new Timestamp(currentDate.getTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", isAdmin=" + admin +
                ", createdDate=" + createdDate +
                '}';
    }
}
