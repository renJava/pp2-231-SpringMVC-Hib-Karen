package web.service;

import web.entity.User;
import java.util.List;

public interface UserService {

    void add(User user);
    void updateUser(User user);
    void deleteUserFromTable(Long id);
    List<User> getAllUsers();
    User findById(Long id);
}
