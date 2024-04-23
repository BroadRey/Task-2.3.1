package ru.largin.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.largin.mvc.dao.UserDAO;
import ru.largin.mvc.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUserById(User user) {
        userDAO.createUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void updateUserById(int id, User updatedUser) {
        userDAO.updateUserById(id, updatedUser);
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
