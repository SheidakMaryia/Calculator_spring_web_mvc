package by.tms.dao;

import by.tms.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    void addUser(User user);

    List<User> getUsers();

    User getUserByLogin(String login);

    boolean isExistUser(User user);

    boolean isExistUserByLogin(String login);
}
