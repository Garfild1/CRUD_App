package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDao;
import web.Model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImp (UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void removeUser(Integer id) {
        userDao.removeUser(id);
    }

    @Override

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional (readOnly = true)
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
