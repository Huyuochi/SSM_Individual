package pers.service;

import pers.entity.User;

public interface UserService {

    int Insert(User user);

    User FindUserByAccount(String account);

    int Register(User user) throws Exception;

}
