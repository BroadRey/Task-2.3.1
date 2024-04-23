package ru.largin.mvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.largin.mvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void updateUserById(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);

        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
}
