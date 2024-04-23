package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import web.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class UsersDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsersList() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }

    public User getUserByID(int id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new BeanPropertyRowMapper<>(User.class), new Object[]{id})
                .stream()
                .findAny()
                .orElse(null);
    }

    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO users (firstName, lastName, age, email) VALUES (?, ?, ?, ?)",
                user.getFirstName(),
                user.getLastName(),
                user.getAge(),
                user.getEmail());
    }

    public void updateUser(int id, User updateUser) {

  jdbcTemplate.update("UPDATE users SET firstName=?, lastName=?, age=?, email=? WHERE id=?",
          updateUser.getFirstName(),
          updateUser.getLastName(),
          updateUser.getAge(),
          updateUser.getEmail(), id);
    }

    public void deleteUser(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }
}
