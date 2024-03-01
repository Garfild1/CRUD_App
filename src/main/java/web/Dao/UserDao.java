package web.Dao;

import web.Model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);
    void removeUser (Integer id);
    void updateUser (User user);
    User getUserById (Integer id);
    List<User> getAllUsers ();



}
