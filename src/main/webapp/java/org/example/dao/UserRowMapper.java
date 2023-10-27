package src.main.webapp.java.org.example.dao;

import org.springframework.jdbc.core.RowMapper;
import src.main.webapp.java.org.example.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();

        user.setUserId(resultSet.getLong("userId"));
        user.setFirstname(resultSet.getString("firstName"));
        user.setLastname(resultSet.getString("lastName"));

        return user;
    }
}
