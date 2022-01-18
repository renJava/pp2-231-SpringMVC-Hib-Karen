package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {

        userDao.add(user);
    }

    @Transactional
    @Override
    public User updateUser(User user) {

        return userDao.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUserFromTable(Long id) {

        userDao.deleteUserFromTable(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {

        return userDao.findById(id);
    }
}
