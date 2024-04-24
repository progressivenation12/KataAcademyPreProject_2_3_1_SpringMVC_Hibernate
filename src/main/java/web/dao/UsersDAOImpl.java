package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsersList() {
        return entityManager.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    public void saveUser(User user) {
        entityManager.merge(user);
    }

    public void updateUser(int id, User updateUser) {
        User toUpdateUser = entityManager.find(User.class, id);

        toUpdateUser.setFirstName(updateUser.getFirstName());
        toUpdateUser.setLastName(updateUser.getLastName());
        toUpdateUser.setAge(updateUser.getAge());
        toUpdateUser.setEmail(updateUser.getEmail());
    }

    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
