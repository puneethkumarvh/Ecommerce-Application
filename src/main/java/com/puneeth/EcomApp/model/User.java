package com.puneeth.EcomApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;

    private String password;

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setPassword(String encode) {
        this.password=encode;
    }

    public String getPassword() {
        return password;
    }
}
