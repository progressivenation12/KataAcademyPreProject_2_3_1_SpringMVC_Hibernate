package web.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT user FROM User user WHERE user.email = :email", User.class);
        query.setParameter("email", email);
        List<User> userList = query.getResultList();
        return userList.isEmpty() ? Optional.empty() : Optional.of(userList.get(0));
    }

    @Override
    public User getUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(int id, User updateUser) {
        User toUpdateUser = entityManager.find(User.class, id);

        toUpdateUser.setFirstName(updateUser.getFirstName());
        toUpdateUser.setLastName(updateUser.getLastName());
        toUpdateUser.setAge(updateUser.getAge());
        toUpdateUser.setEmail(updateUser.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
