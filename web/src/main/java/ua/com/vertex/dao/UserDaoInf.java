package ua.com.vertex.dao;

import ua.com.vertex.util.vo.User;

import java.util.List;

/**
 * Created by sweet_home on 29.10.16.
 */
public interface UserDaoInf {

    List<User> getAllUsers();

    User getUser(long id);

    void deleteUser(long id);
}
