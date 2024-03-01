package web.Service;

import web.Model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void removeUser (Integer id);
    void updateUser (User user);
    User getUserById (Integer id);
    List<User> getAllUsers ();
}
