package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsersList() {
        return userDAO.getUsersList();
    }

    @Override
    public User getUserByID(int id) {
        return userDAO.getUserByID(id);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void updateUser(int id, User updateUser) {
        userDAO.updateUser(id, updateUser);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
