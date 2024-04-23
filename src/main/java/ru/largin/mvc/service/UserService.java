package ru.largin.mvc.service;

import ru.largin.mvc.model.User;

import java.util.List;

public interface UserService {
    void createUserById(User user);
    User getUserById(int id);

    void updateUserById(int id, User updatedUser);
    void deleteUserById(int id);
    List<User> getAllUsers();

}
