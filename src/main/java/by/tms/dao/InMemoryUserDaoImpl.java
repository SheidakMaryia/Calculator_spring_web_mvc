package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserDaoImpl implements UserDao{
    private final static List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user: users){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return new User();
    }

    @Override
    public boolean isExistUser(User user) {
        return users.contains(user);
    }

    @Override
    public boolean isExistUserByLogin(String login) {
        return users.stream().anyMatch(x -> x.getLogin().equals(login));
    }
}
