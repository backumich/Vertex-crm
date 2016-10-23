package ua.com.vertex.util.io;

import ua.com.vertex.util.vo.User;
import ua.com.vertex.util.vo.Users;

import java.io.File;
import java.util.List;

/**
 * Created by sweet_home on 23.10.16.
 */
public interface UserReader {

    List<User> readUsers(File file);

    void writeUsers(File file, Users users);
}
