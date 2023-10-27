package src.main.webapp.java.org.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import src.main.webapp.java.org.example.domain.User;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(User user) {
        String sqlQuery = "INSERT INTO Users(firstname, lastname ,phone , gender) " +
                "VALUES(:firstname, :lastname , :phone , :gender)";
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
         namedParameterJdbcTemplate.update(sqlQuery, params) ;
    }

    @Override
    public User getUser(long userId) {
        String sqlQuery = "SELECT * FROM Users WHERE userid =:userid";
        SqlParameterSource params = new MapSqlParameterSource("userid", userId);

        return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new UserRowMapper());
    }

    @Override
    public List<User> getAllUsers() {
        String sqlQuery = "SELECT * FROM Users";
        return namedParameterJdbcTemplate.query(sqlQuery, new UserRowMapper());
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        String sqlQuery = "UPDATE Users SET firstname = :firstname, " +
                "lastname = :lastname," +
                "phone= :phone," +
                "gender= :gender WHERE Userid = :userId";
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE Users";
        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
    }
}
