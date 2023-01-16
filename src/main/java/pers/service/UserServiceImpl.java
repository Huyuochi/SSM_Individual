package pers.service;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.stereotype.Service;
import pers.dao.UserDao;
import pers.entity.User;
import pers.utils.PasswordUtil;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public int Insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User FindUserByAccount(String account) {
        return userDao.findByAccount(account);
    }

    @Override
    public int Register(User user) throws Exception {
        User tempUser = this.FindUserByAccount(user.getAccount());
        if(tempUser != null) {
            throw new Exception();
        }else {
            RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
            String salt = randomNumberGenerator.nextBytes().toHex();
            user.setSalt(salt);
            String newPassword = PasswordUtil.encryptPassword(user.getPassword(), salt);
            user.setPassword(newPassword);
            return this.Insert(user);
        }
    }
}
