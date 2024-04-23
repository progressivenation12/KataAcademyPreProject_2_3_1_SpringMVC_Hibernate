package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import java.util.List;

@Component
public class UsersDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UsersDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<User> getUsersList() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT user FROM User user", User.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Transactional
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Transactional
    public void updateUser(int id, User updateUser) {
        Session session = sessionFactory.getCurrentSession();
        User toUpdateUser = session.get(User.class, id);

        toUpdateUser.setFirstName(updateUser.getFirstName());
        toUpdateUser.setLastName(updateUser.getLastName());
        toUpdateUser.setAge(updateUser.getAge());
        toUpdateUser.setEmail(updateUser.getEmail());
    }

    @Transactional
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}
