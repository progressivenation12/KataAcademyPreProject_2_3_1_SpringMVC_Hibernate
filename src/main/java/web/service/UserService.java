package web.service;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsersList();
    Optional<User> getUserByEmail(String email);
    User getUserByID(int id);
    void saveUser(User user);
    void updateUser(int id, User updateUser);
    void deleteUser(int id);
}
