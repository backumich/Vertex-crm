package ua.com.vertex.util.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "vertex-users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "vertex-user")
    private List<User> users = new ArrayList<User>();

    public void addUser(User user) {
        users.add(user);
    }

    public void addAllUsers(List<User> users) {
        this.users.addAll(users);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
