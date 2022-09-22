package model;

import util.Id;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String name;
    private String surname;
    private  int id;
    private String username;
    private String password;

    public User(String name, String surname, String username, String password) {
        this.id = Id.getId(DBEnum.USER_ID).orElseThrow();
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id, username, password);
    }

    @Override
    public String toString() {
        return "User{name='%s', surname='%s', id=%d, username='%s', password='%s'}".formatted(name, surname, id, username, password);
    }
}
