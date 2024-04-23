package ru.largin.mvc.dao;

import ru.largin.mvc.model.User;

import java.util.List;

public interface UserDAO {
    void createUser(User user);
    User getUserById(int id);
    void updateUserById(int id, User updatedUser);
    void deleteUserById(int id);
    List<User> getAllUsers();
}