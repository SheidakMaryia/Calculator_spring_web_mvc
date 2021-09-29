package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean save(User user){
        if (!userDao.isExistUser(user)){
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    public Optional<User> findByLogin(String login){
        if (userDao.isExistUserByLogin(login)){
             return Optional.of(userDao.getUserByLogin(login));
        }
       return Optional.empty();
    }










    //From lecture

//    private final List<User> userList = new ArrayList<>();
//
//    public void save(User user){
//        userList.add(user);
//    }
//
//    public User findByLogin(String login){
//        for (User user : userList) {
//            if (user.getLogin().equals(login)){
//                return user;
//            }
//        }
//        return null;
//    }
}
