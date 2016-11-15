package ua.com.vertex.dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.stereotype.Repository;
import ua.com.vertex.util.vo.User;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class UserDao implements UserDaoInf {

    private DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<>();
        String select = "SELECT key1 AS id, field1 AS name FROM Table1";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {

            User user;
            while (resultSet.next()) {
                user = new User(resultSet.getLong("id"),
                        resultSet.getString("name"));
                result.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public User getUser(long id) {

        String query = "SELECT key1 AS id, field1 AS name FROM Table1 WHERE key1 in (?)";

        User user = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User(resultSet.getLong("id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {

    }

    public static void main(String[] args) throws IOException {

//        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Properties properties = new Properties();
        properties.load(UserDao.class.getClassLoader()
                .getResourceAsStream("db.properties"));


        DataSource dataSource = new MysqlDataSource();

        ((MysqlDataSource) dataSource).setURL(properties.getProperty("url"));
        ((MysqlDataSource) dataSource).setUser(properties.getProperty("user"));
        ((MysqlDataSource) dataSource).setPassword(properties.getProperty("password"));

        UserDaoInf userDao = new UserDao(dataSource);

        System.out.println(userDao.getAllUsers());
        System.out.println(userDao.getUser(3L));
    }
}
