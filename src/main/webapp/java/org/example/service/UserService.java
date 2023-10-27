package src.main.webapp.java.org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import src.main.webapp.java.org.example.dao.UserDao;
import src.main.webapp.java.org.example.domain.User;

import java.util.List;

@Service
public class UserService {
    static private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public void createSeedData() {

        User user1 = new User(0, "Shabnam",
                "Shoaei", "123654789", "female");

        User user2 = new User(0, "sara",
                "serd", "857496321", "female");

        User user3 = new User(0, "john",
                "wheid", "8745213699", "male");

        var Users = List.of(user1, user2, user3);

        Users.stream().forEach(u -> userDao.create(u));

    }

    public void printProduct(User user) {

        System.out.println("print User ...." + user);
    }

    public void printProducts() {

        List<User> users = getAllUsers();

        users.stream().forEach(org -> LOGGER.info(org.toString()));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(String firstname, String lastname, String phone, String gender) {

        User user = new User(0, firstname, lastname,
                phone, gender);

        userDao.create(user);

    }

    public User getUser(long UseridId) {

        return userDao.getUser(UseridId);

    }

    public void updateUser(Long userid ,String firstname, String lastname, String phone, String gender) {

        User user  = new User(userid, firstname, lastname,
                phone, gender);

        userDao.update(user);
    }
}
