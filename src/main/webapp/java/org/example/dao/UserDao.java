package src.main.webapp.java.org.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.webapp.java.org.example.domain.User;

import javax.sql.DataSource;
import java.util.List;


public interface UserDao {
    @Autowired
    void setDataSource(DataSource dataSource);

    void create(User user);

    User getUser(long userId);

    List<User> getAllUsers();

    boolean delete(User user);

    boolean update(User user);

    void cleanup();
}
